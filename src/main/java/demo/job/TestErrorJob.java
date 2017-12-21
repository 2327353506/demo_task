package demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author wangmt
 * @date 2017/11/14
 */
public class TestErrorJob implements Job{

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("开始定时任务");
        throw new RuntimeException("测试异常");
    }
}
