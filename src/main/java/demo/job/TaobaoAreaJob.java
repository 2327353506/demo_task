package demo.job;

import demo.service.TaobaoAreaService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangmt
 * @date 2017/12/21
 */
public class TaobaoAreaJob implements Job {

    @Autowired
    private TaobaoAreaService taobaoAreaService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        taobaoAreaService.pullTaobaoArea();

    }
}
