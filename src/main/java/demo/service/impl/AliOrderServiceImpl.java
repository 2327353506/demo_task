package demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.trade.param.*;
import demo.dao.oms.*;
import demo.po.oms.*;
import demo.service.AliOrderService;
import demo.util.DateHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * @author wangmt
 * @date 2017/11/28
 */
@Service
public class AliOrderServiceImpl implements AliOrderService {

    @Autowired
    private PlatformAliRefundDao platformAliRefundDao;
    @Autowired
    private PlatformAliTradeContactDao platformAliTradeContactDao;
    @Autowired
    private PlatformAliTradeDao platformAliTradeDao;
    @Autowired
    private PlatformAliTradeLogisticDao platformAliTradeLogisticDao;
    @Autowired
    private PlatformAliTradeProductDao platformAliTradeProductDao;
    @Autowired
    private PlatformAliInvoiceDao platformAliInvoiceDao;


    private static String appKey = "9231059";
    private static String appSecret = "reMNBKJ36c";
    private static String token = "c9b5c720-eb9f-43a7-9886-cc27b3276850";
    private static String refreshToken = "709fb774-1081-4cd3-96f9-5b28016b4939";

    private ApiExecutor executor = new ApiExecutor(appKey,appSecret);

    /**
     * 拉取订单信息
     */
    @Override
    public void pullOrderInfo()  {

        Date d = new Date();
        //创建API访问Facade对象
        AlibabaTradeGetSellerOrderListParam param = new AlibabaTradeGetSellerOrderListParam();
        param.setModifyStartTime(DateHelper.addDate(d,-7, Calendar.DATE));
        param.setModifyEndTime(d);
        //调用接口
        AlibabaTradeGetSellerOrderListResult res = executor.execute(param,token);
        AlibabaOpenplatformTradeModelTradeInfo[] tradeList = res.getResult();

        for (AlibabaOpenplatformTradeModelTradeInfo trade: tradeList) {
            //赋值
            PlatformAliTrade platformAliTrade = new  PlatformAliTrade();
            platformAliTrade.setBuyerId(trade.getBaseInfo().getBuyerID());
            platformAliTrade.setSellerId(trade.getBaseInfo().getSellerID());
            BeanUtils.copyProperties(trade.getBaseInfo(),platformAliTrade);
            BeanUtils.copyProperties(trade.getBaseInfo().getReceiverInfo(),platformAliTrade);
            PlatformAliTrade t = platformAliTradeDao.findById(platformAliTrade.getId());

            if(t != null){
                platformAliTradeDao.update(platformAliTrade);
            }else{
                //处理订单子业务
                PlatformAliTradeLogistic logistic = pullOrderLogistic(trade);
                PlatformAliTradeContact buyer = pullOrderBuyer(trade,1);
                PlatformAliTradeContact seller = pullOrderBuyer(trade,2);
                PlatformAliInvoice invoice = pullOrderInvoice(trade);
                pullOrderGoods(trade);
                platformAliTradeDao.save(platformAliTrade);
            }

        }
    }

    /**
     * 拉取商品
     * @param trade
     */
    private void pullOrderGoods(AlibabaOpenplatformTradeModelTradeInfo trade) {

        if(trade.getProductItems() == null || trade.getProductItems().length==0){
            return;
        }

        for (AlibabaOpenplatformTradeModelProductItemInfo item: trade.getProductItems()) {
            PlatformAliTradeProduct product = new PlatformAliTradeProduct();
            BeanUtils.copyProperties(item,product);
            product.setTid(trade.getBaseInfo().getId());
            product.setProductId(item.getProductID());
            product.setSkuId(item.getSkuID());
            product.setSubitemId(item.getSubItemID());
            if(item.getProductImgUrl() != null && item.getProductImgUrl().length>0){
                product.setProductImgUrl(JSON.toJSONString(item.getProductImgUrl()));
            }
            platformAliTradeProductDao.save(product);
        }
    }

    /**
     * 保存订单发票信息
     * @param trade
     * @return
     */
    private PlatformAliInvoice pullOrderInvoice(AlibabaOpenplatformTradeModelTradeInfo trade) {
        PlatformAliInvoice invoice = new PlatformAliInvoice();

        if(trade.getOrderInvoiceInfo() == null){
            return null;
        }
        BeanUtils.copyProperties(trade.getOrderInvoiceInfo(),invoice);
        invoice.setTid(trade.getBaseInfo().getId());
        platformAliInvoiceDao.save(invoice);
        return invoice;
    }

    /**
     * 保存订单买家信息
     * @param trade
     * @return
     */
    private PlatformAliTradeContact pullOrderBuyer(AlibabaOpenplatformTradeModelTradeInfo trade,int type) {
        PlatformAliTradeContact buyer = new PlatformAliTradeContact();
        if(type==1){

            if(trade.getBaseInfo().getBuyerContact() == null){
                return null;
            }
            BeanUtils.copyProperties(trade.getBaseInfo().getBuyerContact(),buyer);
        }else if(type==2){

            if(trade.getBaseInfo().getSellerContact() == null){
                return null;
            }
            BeanUtils.copyProperties(trade.getBaseInfo().getSellerContact(),buyer);
        }else{

            return null;
        }
        buyer.setTid(trade.getBaseInfo().getId());
        buyer.setType(type);
        platformAliTradeContactDao.save(buyer);
        return buyer;
    }

    /**
     * 保存订单地址信息
     * @param trade
     * @return
     */
    private PlatformAliTradeLogistic pullOrderLogistic(AlibabaOpenplatformTradeModelTradeInfo trade) {
        PlatformAliTradeLogistic logistic = new PlatformAliTradeLogistic();

        if(trade.getNativeLogistics() == null){
            return null;
        }
        BeanUtils.copyProperties(trade.getNativeLogistics(),logistic);
        logistic.setTid(trade.getBaseInfo().getId());
        platformAliTradeLogisticDao.save(logistic);
        return logistic;
    }

    /**
     * 拉取退款信息
     */
    @Override
    public void pullRefundOrder() {

        Date d = new Date();
        ApiExecutor executor = new ApiExecutor(appKey,appSecret);
        AlibabaTradeRefundQueryOrderRefundListParam param = new AlibabaTradeRefundQueryOrderRefundListParam();
        param.setModifyStartTime(DateHelper.addDate(d,-7, Calendar.DATE));
        param.setModifyEndTime(d);
        AlibabaTradeRefundQueryOrderRefundListResult res = executor.execute(param,token);
        AlibabaTradeRefundOpQueryOrderRefundListResult refundRes = res.getResult();

        for (AlibabaTradeRefundOpOrderRefundModel  refund: refundRes.getOpOrderRefundModels()) {
            PlatformAliRefund aliRefund = new PlatformAliRefund();
            BeanUtils.copyProperties(refund,aliRefund);
            platformAliRefundDao.save(aliRefund);
        }
    }
}
