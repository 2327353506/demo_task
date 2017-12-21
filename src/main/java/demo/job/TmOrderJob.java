package demo.job;

import demo.service.JdOrderService;
import demo.service.TmOrderService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 天猫订单拉取
 * @author wangmt
 * @date 2017/11/21
 */
public class TmOrderJob implements Job {

    @Autowired
    private TmOrderService tmOrderService;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        tmOrderService.pullOrderInfo();
        tmOrderService.pullRefundOrder();
    }

}
