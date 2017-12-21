package demo.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import demo.service.JdOrderService;
import demo.util.DateHelper;
import demo.util.YmlUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author wangmt
 * @date 2017/11/15
 */
@Service
public class JdOrderJob implements Job {

    @Autowired
    private JdOrderService jdOrderService;


    @Override
    public void execute(JobExecutionContext ApplicationHelper) throws JobExecutionException {
        JSONObject store = (JSONObject) JSONObject.toJSON(YmlUtil.cache.get("store"));
        JSONArray jd = store.getJSONArray("jd");
        for (int i = 0,len = jd.size(); i < len; i++) {
            JSONObject item = jd.getJSONObject(i);
            String storeName = item.getString("storeName");
            String token = item.getString("token");
            System.out.println(storeName+"开始时间"+ DateHelper.getCurrentTime());
            try{
                jdOrderService.pullOrderInfo(token,storeName);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(storeName+"结束时间"+ DateHelper.getCurrentTime());
        }
    }



}
