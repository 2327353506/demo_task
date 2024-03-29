package demo.vo;

import org.quartz.Scheduler;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

/**
 * @author wangmt
 * @date 2017/11/14
 */
public class SchedulingJob {


    public static final int JS_ENABLED = 0; // 任务启用状态
    public static final int JS_DISABLED = 1; // 任务禁用状态
    public static final int JS_DELETE = 2; // 任务已删除状态

    private String jobId; // 任务的Id，一般为所定义Bean的ID
    private String jobName; // 任务的描述
    private String jobGroup; // 任务所属组的名称
    private int jobStatus; // 任务的状态，0：启用；1：禁用；2：已删除
    private String cronExpression; // 定时任务运行时间表达式
    private String memos; // 任务描述
    private Class<? extends MethodInvokingJobDetailFactoryBean.StatefulMethodInvokingJob> stateFulljobExecuteClass;//同步的执行类，需要从StatefulMethodInvokingJob继承
    private Class<? extends MethodInvokingJobDetailFactoryBean.MethodInvokingJob> jobExecuteClass;//异步的执行类，需要从MethodInvokingJob继承
    /**
     * 得到该job的Trigger名字
     * @return
     */
    public String getTriggerName() {
        return this.getJobId() + "Trigger";
    }
    public String getJobId() {
        return jobId;
    }
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    public String getJobName() {
        return jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getJobGroup() {
        if(jobGroup==null){
            jobGroup = Scheduler.DEFAULT_GROUP;
        }
        return jobGroup;
    }
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }
    public int getJobStatus() {
        return jobStatus;
    }
    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }
    public String getCronExpression() {
        return cronExpression;
    }
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
    public String getMemos() {
        return memos;
    }
    public void setMemos(String memos) {
        this.memos = memos;
    }

    public static int getJS_ENABLED() {
        return JS_ENABLED;
    }
    public static int getJS_DISABLED() {
        return JS_DISABLED;
    }
    public static int getJS_DELETE() {
        return JS_DELETE;
    }

    public void setStateFulljobExecuteClass(Class<? extends MethodInvokingJobDetailFactoryBean.StatefulMethodInvokingJob> stateFulljobExecuteClass) {
        this.stateFulljobExecuteClass = stateFulljobExecuteClass;
    }

    public Class<? extends MethodInvokingJobDetailFactoryBean.MethodInvokingJob> getJobExecuteClass() {
        return jobExecuteClass;
    }

    public void setJobExecuteClass(Class<? extends MethodInvokingJobDetailFactoryBean.MethodInvokingJob> jobExecuteClass) {
        this.jobExecuteClass = jobExecuteClass;
    }

    public Class<? extends MethodInvokingJobDetailFactoryBean.StatefulMethodInvokingJob> getStateFulljobExecuteClass() {
        return stateFulljobExecuteClass;
    }
}
