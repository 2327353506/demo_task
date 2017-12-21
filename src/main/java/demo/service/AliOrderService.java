package demo.service;

/**
 * @author wangmt
 * @date 2017/11/28
 */
public interface AliOrderService {
    /**
     * 拉取订单信息
     */
    void pullOrderInfo();

    /**
     * 拉取退款信息
     */
    void pullRefundOrder();
}
