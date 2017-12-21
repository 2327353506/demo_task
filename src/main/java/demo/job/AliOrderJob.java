package demo.job;

import demo.service.AliOrderService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangmt
 * @date 2017/11/28
 */
public class AliOrderJob implements Job{
    @Autowired
    private AliOrderService aliOrderService;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        aliOrderService.pullOrderInfo();
        aliOrderService.pullRefundOrder();
    }
}
