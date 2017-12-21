package demo.util;

import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.trade.param.AlibabaTradeGetSellerOrderListParam;
import com.alibaba.trade.param.AlibabaTradeGetSellerOrderListResult;

import java.util.Date;

/**
 * @author wangmt
 * @date 2017/11/23
 */
public class AliServiceUtil {

    private static String appKey = "9231059";
    private static String appSecret = "reMNBKJ36c";
    private static String token = "c9b5c720-eb9f-43a7-9886-cc27b3276850";
    private static String refreshToken = "709fb774-1081-4cd3-96f9-5b28016b4939";

    public static AlibabaTradeGetSellerOrderListResult toConnAli(Date start,Date end) throws Exception {

        ApiExecutor executor = new ApiExecutor(appKey,appSecret);
        //AuthorizationToken authToken = executor.refreshToken(refreshToken);
        //创建API访问Facade对象
        AlibabaTradeGetSellerOrderListParam param = new AlibabaTradeGetSellerOrderListParam();
        param.setModifyStartTime(start);
        param.setModifyEndTime(end);
        //System.out.println(authToken.getAccess_token());
        return executor.execute(param,token);
    }

}
