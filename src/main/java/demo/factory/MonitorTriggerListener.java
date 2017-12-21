package demo.factory;

import com.alibaba.fastjson.JSON;
import demo.po.SysJobLog;
import demo.service.TaskJobService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author wangmt
 * @date 2017/12/1
 */
public class MonitorTriggerListener implements TriggerListener, SchedulerListener {

    @Autowired
    private TaskJobService service;
    private ThreadLocal<SysJobLog> localLog=new ThreadLocal<>();
    private ThreadLocal<String> id=new ThreadLocal<>();

    @Override
    public String getName() {
        return "监控中心";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        try{
            SysJobLog log = new SysJobLog();
            log.setStartTime(new Date());
            log.setStatus(1);
            log.setJobClass(jobExecutionContext.getJobDetail().getJobClass().getName());
            //service.saveJobLog(log);
            localLog.set(log);
        } catch (Exception e) {
            System.out.println("记录job开始时间异常");
        }catch (Throwable e) {
            System.out.println("记录job开始时间出错");
        }
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        System.out.println("vetoJobExecution");
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        System.out.println("triggerMisfired");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
    }

    @Override
    public void jobScheduled(Trigger trigger) {

    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {

    }

    @Override
    public void triggerFinalized(Trigger trigger) {

    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {

    }

    @Override
    public void triggersPaused(String s) {

    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {

    }

    @Override
    public void triggersResumed(String s) {

    }

    @Override
    public void jobAdded(JobDetail jobDetail) {

    }

    @Override
    public void jobDeleted(JobKey jobKey) {

    }

    @Override
    public void jobPaused(JobKey jobKey) {

    }

    @Override
    public void jobsPaused(String s) {

    }

    @Override
    public void jobResumed(JobKey jobKey) {

    }

    @Override
    public void jobsResumed(String s) {

    }

    @Override
    public void schedulerError(String s, SchedulerException e) {
        try {
            SysJobLog log = localLog.get();
            if(log==null){
                return ;
            }
            log.setErrorInfo(e.toString());
            log.setStatus(-1);
            log.setEndTime(new Date());
            service.stopTaskByClass(log.getJobClass());
            service.saveJobLog(log);
        } catch (Exception e1) {
            System.out.println("记录job结束时间异常");
        }catch (Throwable e1) {
            System.out.println("记录job结束时间出错");
        }
    }

    @Override
    public void schedulerInStandbyMode() {

    }

    @Override
    public void schedulerStarted() {

    }

    @Override
    public void schedulerStarting() {

    }

    @Override
    public void schedulerShutdown() {

    }

    @Override
    public void schedulerShuttingdown() {

    }

    @Override
    public void schedulingDataCleared() {

    }
}
