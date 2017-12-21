package demo.service;

/**
 * @author wangmt
 * @date 2017/11/21
 */
public interface TmOrderService {

    /**
     * 同步天猫订单
     */
    void pullOrderInfo();

    /**
     * 同步退款单
     */
    void pullRefundOrder();
}
