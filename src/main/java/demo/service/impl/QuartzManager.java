package demo.service.impl;

import demo.factory.MonitorTriggerListener;
import demo.po.TaskJob;
import demo.vo.SchedulingJob;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangmt
 * @date 2017/11/14
 */
@Service
public class QuartzManager {
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;


    private static final Log log = LogFactory.getLog(QuartzManager.class);
    public void enableCronSchedule(List<TaskJob> list) throws SchedulerException {
        MonitorTriggerListener listener = capableBeanFactory.createBean(MonitorTriggerListener.class);
        scheduler.getListenerManager().addTriggerListener(listener);
        scheduler.getListenerManager().addSchedulerListener(listener);
        for(TaskJob task : list){
            SchedulingJob job = new SchedulingJob();
            job.setJobId(String.valueOf(task.getId()));
            job.setJobName(task.getJobClass());
            //job.setMemos(task.getNote());
            job.setCronExpression(task.getJobCronExpression());
            try{
                String  className=  task.getJobClass().trim();
                Class clazz = Class.forName(className);
                job.setStateFulljobExecuteClass(clazz);
            }catch(Exception e){
                e.printStackTrace();
                continue;
            }
            JobDataMap paramsMap = new JobDataMap();
            //paramsMap.put("jobName", task.getJobName());

            enableCronSchedule(job, paramsMap, true);

            log.info("系统结束初始化任务："+task.getId()+":"+task.getJobName()+":"+task.getJobId());
        }
    }
    /**
     * 启动一个自定义的job
     *
     * @param schedulingJob
     *            自定义的job
     * @param paramsMap
     *            传递给job执行的数据
     * @param isStateFull
     *            是否是一个同步定时任务，true：同步，false：异步
     * @return 成功则返回true，否则返回false
     */
    public boolean enableCronSchedule(SchedulingJob schedulingJob, JobDataMap paramsMap, boolean isStateFull) {
        if (schedulingJob == null) {
            return false;
        }
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(schedulingJob.getTriggerName(), schedulingJob.getJobGroup());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (null == trigger) {// 如果不存在该trigger则创建一个
                JobDetail jobDetail = null;
                if (isStateFull) {
                    jobDetail = JobBuilder.newJob(schedulingJob.getStateFulljobExecuteClass())
                                .withIdentity(schedulingJob.getJobName(), schedulingJob.getJobGroup())
                                .build();
                } else {
                    jobDetail = JobBuilder.newJob(schedulingJob.getJobExecuteClass())
                                .withIdentity(schedulingJob.getJobName(), schedulingJob.getJobGroup())
                                .build();
                }
                CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(schedulingJob.getCronExpression());
                trigger = TriggerBuilder.newTrigger()
                            .withIdentity(schedulingJob.getJobId(), schedulingJob.getJobGroup())
                            .withSchedule(cronSchedule)
                            .build();
                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(schedulingJob.getCronExpression());
                // Trigger已存在，那么更新相应的定时设置
                trigger.getTriggerBuilder().withSchedule(cronSchedule);
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 禁用一个job
     *
     * @param jobId
     *            需要被禁用的job的ID
     * @return 成功则返回true，否则返回false
     */
    public boolean disableSchedule(String jobId) {
        if (jobId.equals("")) {
            return false;
        }
        try {
            String jobGroupId="DEFAULT";
            Trigger trigger = getJobTrigger(jobId, jobGroupId);
            if (null != trigger) {
                scheduler.deleteJob(trigger.getJobKey());
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 得到job的详细信息
     *
     * @param jobId
     *            job的ID
     * @param jobGroupId
     *            job的组ID
     * @return job的详细信息,如果job不存在则返回null
     */
    public JobDetail getJobDetail(String jobId, String jobGroupId) {
        if (jobId.equals("") || jobGroupId.equals("") || null == jobId || jobGroupId == null) {
            return null;
        }
        try {
            Trigger trigger = getJobTrigger(jobId, jobGroupId);
            return scheduler.getJobDetail(trigger.getJobKey());
        } catch (SchedulerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 得到job对应的Trigger
     *
     * @param jobId
     *            job的ID
     * @param jobGroupId
     *            job的组ID
     * @return job的Trigger,如果Trigger不存在则返回null
     */
    public Trigger getJobTrigger(String jobId, String jobGroupId) {
        if (jobId.equals("") || jobGroupId.equals("") || null == jobId || jobGroupId == null) {
            return null;
        }
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobId, jobGroupId);
            return scheduler.getTrigger(triggerKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
