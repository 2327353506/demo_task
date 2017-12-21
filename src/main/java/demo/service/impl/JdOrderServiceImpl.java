package demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.domain.order.OrderQueryJsfService.OrderListResult;
import com.jd.open.api.sdk.domain.order.OrderQueryJsfService.OrderSearchInfo;
import com.jd.open.api.sdk.request.order.PopOrderSearchRequest;
import com.jd.open.api.sdk.response.order.PopOrderSearchResponse;
import com.mchange.v1.util.ClosableResourceUtils;
import demo.dao.oms.*;
import demo.po.oms.*;
import demo.service.JdOrderService;
import demo.util.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author wangmt
 * @date 2017/11/15
 */
@Service
public class JdOrderServiceImpl implements JdOrderService{

    private static final String SEARCH_PARAM = "orderId,venderId,orderType,payType,orderTotalPrice,orderSellerPrice,orderPayment,freightPrice,sellerDiscount,orderState,orderStateRemark,deliveryType,invoiceInfo,invoiceCode,orderRemark,orderStartTime,orderEndTime,consigneeInfo,itemInfoList,couponDetailList,venderRemark,balanceUsed,pin,returnOrder,paymentConfirmTime,waybill,logisticsId,vatInfo,modified,directParentOrderId,parentOrderId,customs,customsModel,orderSource,storeOrder,idSopShipmenttype,scDT,serviceFee,pauseBizInfo,taxFee,tuiHuoWuYou,orderSign,storeId";

    private static final String SEARCH_STATUS = "WAIT_SELLER_STOCK_OUT,WAIT_GOODS_RECEIVE_CONFIRM,FINISHED_L,TRADE_CANCELED,LOCKED,WAIT_SELLER_DELIVERY";

    private static final String SERVER_URL = "https://api.jd.com/routerjson";

    private static final String APP_KEY = "848D4EFC5A2B575943E84FE8C42D2EC4";

    private static final String APP_SECRET = "56927cd746c14ec094f51640546ef360";


    @Autowired
    private PlatformJdOrderinfoDao jdOrderinfoDao;
    @Autowired
    private PlatformJdIteminfoDao jdIteminfoDao;
    @Autowired
    private PlatformJdCouponDao jdCouponDetailDao;
    @Autowired
    private PlatformJdVatinfoDao jdVatinfoDao;
    @Autowired
    private PlatformJdUserinfoDao jdUserinfoDao;

    /**
     * 拉取京东订单
     * @param token
     * @param storeName
     */
    @Override
    public void pullOrderInfo(String token, String storeName) {
        String ACCESS_TOKEN = token;
        JdClient client=new DefaultJdClient(SERVER_URL,ACCESS_TOKEN,APP_KEY,APP_SECRET);
        PopOrderSearchRequest request = getInitRequest();
        try  {
            int total = 100;
            while (total == 100){
                PopOrderSearchResponse response=client.execute(request);
                if(!"0".equals(response.getCode())){
                    throw new RuntimeException(response.getZhDesc());
                }
                OrderListResult res = response.getSearchorderinfoResult();
                if(!res.getApiResult().getSuccess()){
                    throw new RuntimeException(res.getApiResult().getChineseErrCode());
                }
                List<OrderSearchInfo> list = res.getOrderInfoList();
                total = list.size();
                for (OrderSearchInfo order : list) {
                    PlatformJdOrderinfo o = parseObject(order,PlatformJdOrderinfo.class);
                    PlatformJdOrderinfo po  = jdOrderinfoDao.findById(o.getOrderId());
                    List<PlatformJdIteminfo> items = parseArray(order.getItemInfoList(),PlatformJdIteminfo.class);
                    List<PlatformJdCoupon> couponDetails = parseArray(order.getCouponDetailList(),PlatformJdCoupon.class);
                    PlatformJdVatinfo vinfo = parseObject(order.getVatInfo(),PlatformJdVatinfo.class);
                    PlatformJdUserinfo userinfo = parseObject(order.getConsigneeInfo(),PlatformJdUserinfo.class);
                    if(po != null){
                        //更新订单状态等
                        jdOrderinfoDao.update(o);
                    }else{
                        if(userinfo != null){
                            //保存订单用户信息
                            jdUserinfoDao.save(userinfo);
                            o.setUserinfoId(userinfo.getId());
                        }
                        if(vinfo != null){
                            //保存订单用户发票信息
                            jdVatinfoDao.save(vinfo);
                            o.setVatinfoId(vinfo.getId());
                        }
                        //保存订单信息
                        jdOrderinfoDao.save(o);
                        for (PlatformJdIteminfo item : items) {
                            //保存订单商品
                            item.setOrderId(o.getOrderId());
                            jdIteminfoDao.save(item);
                        }
                        for (PlatformJdCoupon item : couponDetails) {
                            //保存订单活动信息
                            item.setOrderId(o.getOrderId());
                            jdCouponDetailDao.save(item);
                        }
                    }
                }
                request.setPage(String.valueOf(Integer.parseInt(request.getPage())+1));
            }
        } catch (JdException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化固定参数
     * @return
     */
    private PopOrderSearchRequest getInitRequest() {
        PopOrderSearchRequest request = new PopOrderSearchRequest();
        Date date = new Date();
        request.setStartDate(DateHelper.addDate(date,-5,Calendar.DATE,"yyyy-MM-dd HH:mm:ss"));
        request.setEndDate(DateHelper.getFormatTime(date));
        request.setSortType(1);
        request.setOrderState(SEARCH_STATUS);
        request.setPage("1");
        request.setPageSize("100");
        request.setDateType(0);
        request.setOptionalFields(SEARCH_PARAM);
        return request;
    }

    public <T> T parseObject(Object o, Class<T> c){
        return JSONObject.parseObject(JSONObject.toJSONString(o),c);
    }

    public <T> List<T> parseArray(List<?> o, Class<T> c){
        return JSONObject.parseArray(JSONObject.toJSONString(o),c);
    }

}
