package demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import demo.dao.oms.*;
import demo.dao.pspire.JdpTbRefundDao;
import demo.dao.pspire.JdpTbTradeDao;
import demo.po.jdp.JdpTbRefund;
import demo.po.jdp.JdpTbTrade;
import demo.po.oms.*;
import demo.service.TmOrderService;
import demo.util.Underline2Camel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wangmt
 * @date 2017/11/21
 */
@Service
public class TmOrderServiceImpl implements TmOrderService{

    @Autowired
    private JdpTbTradeDao jdpTbTradeDao;
    @Autowired
    private JdpTbRefundDao jdpTbRefundDao;
    @Autowired
    private PlatformTaobaoTradeDao taobaoTradeDao;
    @Autowired
    private PlatformTaobaoOrderDao taobaoOrderDao;
    @Autowired
    private PlatformTaobaoPromotionDao taobaoPromotionDetailDao;
    @Autowired
    private PlatformTaobaoServiceOrderDao taobaoServiceOrderDao;
    @Autowired
    private PlatformTaobaoRefundDao taobaoRefundDao;

    private static final int limit = 100;
    /**
     * 同步天猫订单
     */
    @Override
    public void pullOrderInfo() {

        int total = limit;
        int i = 0;
        while (total == limit){

            List<JdpTbTrade> list = jdpTbTradeDao.findList(i);
            if(list != null){

                total = 1;
            }else{
                break;
            }

            for (JdpTbTrade trade: list) {

                JSONObject res = JSONObject.parseObject(trade.getJdpResponse());
                JSONObject tradeFullinfoGetResponse = res.getJSONObject("trade_fullinfo_get_response");
                JSONObject tradeJson = tradeFullinfoGetResponse.getJSONObject("trade");
/*                JSONObject source = new JSONObject();

                for (Map.Entry<String, Object> entity: tradeJson.entrySet()) {

                    String key = entity.getKey();
                    Object o = tradeJson.get(key);
                    source.put(Underline2Camel.toCamel(key),o);
                }*/
                PlatformTaobaoTrade t = Json2Object(tradeJson,PlatformTaobaoTrade.class);

                pullOrder(tradeJson.getJSONObject("orders"),t.getTid());
                pullPromotion(tradeJson.getJSONObject("promotion_details"),t.getTid());
                pullService(tradeJson.getJSONObject("service_orders"),t.getTid());

                PlatformTaobaoTrade data = taobaoTradeDao.findById(t.getTid());
                if(data == null){
                    taobaoTradeDao.save(t);
                }
            }
        }

    }

    /**
     * 同步退款单
     */
    @Override
    public void pullRefundOrder() {

        int total = limit;
        int i = 0;
        while (total == limit) {

            List<JdpTbRefund> list = jdpTbRefundDao.findList(i);
            if(list != null){

                total = 1;
            }else{
                break;
            }
            for (JdpTbRefund refund: list) {
                JSONObject res = JSONObject.parseObject(refund.getJdpResponse());
                JSONObject refundGetResponse = res.getJSONObject("refund_get_response");
                JSONObject refundJson = refundGetResponse.getJSONObject("refund");
                try{
                    PlatformTaobaoRefund t = Json2Object(refundJson,PlatformTaobaoRefund.class);
                    PlatformTaobaoRefund ref = taobaoRefundDao.findById(t.getRefundId());
                    if(ref == null){
                        taobaoRefundDao.save(t);
                    }
                }catch (Exception e){
                    System.out.println(refundJson.toJSONString());
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * JSON转Java对象(下划线转驼峰，TRUE = 1 FALSE = 0)
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    private <T>T Json2Object(JSONObject json, Class<T> clazz) {
        if(json == null){
            return null;
        }
        JSONObject source = new JSONObject();

        for (Map.Entry<String, Object> entity: json.entrySet()) {

            String key = entity.getKey();
            Object o = json.get(key);

            if(o != null && "false".equals(o.toString())){
                o =0;
            }else if(o != null && "true".equals(o.toString())){
                o =1;
            }

            source.put(Underline2Camel.toCamel(key),o);
        }
        return JSONObject.parseObject(source.toJSONString(),clazz);
    }

    /**
     * 解析阿里订单子服务订单
     * @param serviceTags
     * @param tid
     */
    private void pullService(JSONObject serviceTags, Long tid) {

        if(serviceTags != null){
            JSONArray logistics = serviceTags.getJSONArray("service_order");

            for (int i = 0,len = logistics.size(); i < len; i++) {
                JSONObject item = logistics.getJSONObject(i);
/*                JSONObject source = new JSONObject();

                for (Map.Entry<String, Object> entity: item.entrySet()) {
                    String key = entity.getKey();
                    Object o = item.get(key);
                    source.put(Underline2Camel.toCamel(key),o);
                }*/

                PlatformTaobaoServiceOrder t = Json2Object(item,PlatformTaobaoServiceOrder.class);
                t.setTid(tid);

                taobaoServiceOrderDao.save(t);
            }
        }
    }


    /**
     * 解析阿里订单优惠
     * @param promotionDetails
     * @param tid
     */
    private void pullPromotion(JSONObject promotionDetails, Long tid) {

        if(promotionDetails != null){

            JSONArray promotion = promotionDetails.getJSONArray("promotion_detail");
            for (int i = 0,len = promotion.size(); i < len; i++) {
                JSONObject item = promotion.getJSONObject(i);
/*                JSONObject source = new JSONObject();

                for (Map.Entry<String, Object> entity: item.entrySet()) {
                    String key = entity.getKey();
                    Object o = item.get(key);
                    source.put(Underline2Camel.toCamel(key),o);
                }*/
                PlatformTaobaoPromotion t = Json2Object(item,PlatformTaobaoPromotion.class);
                t.setId(null);
                t.setTid(tid);
                taobaoPromotionDetailDao.save(t);
                //System.out.println(t);
            }
        }
    }

    /**
     * 解析阿里订单并保存
     * @param orders
     * @param tid
     */
    private void pullOrder(JSONObject orders, Long tid) {

        if(orders != null){

            JSONArray order = orders.getJSONArray("order");
            for (int i = 0,len = order.size(); i < len; i++) {
                JSONObject item = order.getJSONObject(i);
/*                JSONObject source = new JSONObject();

                for (Map.Entry<String, Object> entity: item.entrySet()) {
                    String key = entity.getKey();
                    Object o = item.get(key);
                    if(o != null && "false".equals(o.toString())){
                        o =0;
                    }
                    if(o != null && "true".equals(o.toString())){
                        o =1;
                    }
                    source.put(Underline2Camel.toCamel(key),o);
                }*/
                PlatformTaobaoOrder t = Json2Object(item,PlatformTaobaoOrder.class);
                t.setTid(tid);
                taobaoOrderDao.save(t);
                //System.out.println(t);
            }
        }
    }
}
