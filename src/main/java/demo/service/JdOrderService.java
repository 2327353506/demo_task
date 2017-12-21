package demo.service;

/**
 * @author wangmt
 * @date 2017/11/15
 */
public interface JdOrderService {

    /**
     * 拉取京东订单
     * @param token
     * @param storeName
     */
    void pullOrderInfo(String token, String storeName);
}
