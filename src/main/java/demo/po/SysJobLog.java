package demo.po;

import java.util.Date;

/**
 * @author wangmt
 * @date 2017/12/1
 */
public class SysJobLog {


    private Long id;

    //工作类
    private String jobClass;

    //开始时间
    private Date startTime;

    //结束时间
    private Date endTime;

    //任务状态
    private int status;

    //异常信息
    private String errorInfo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }


}
