package demo.po.oms;

/**
 * @author wangmt
 * @date 2017/11/15
 */
public class PlatformJdCoupon {

    /**
     * 订单编号
     */
    private Long orderId;

    /**
     * 京东sku编号
     */
    private String skuId;

    /**
     * 优惠类型: 20-套装优惠, 28-闪团优惠, 29-团购优惠, 30-单品促销优惠, 34-手机红包, 35-满返满送(返现), 39-京豆优惠,41-京东券优惠, 52-礼品卡优惠,100-店铺优惠
     */
    private String couponType;

    /**
     * 优惠金额
     */
    private String couponPrice;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(String couponPrice) {
        this.couponPrice = couponPrice;
    }
}
