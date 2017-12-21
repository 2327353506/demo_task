package demo.po.oms;

/**
 * @author wangmt
 * @date 2017/11/15
 */
public class PlatformJdIteminfo {

    /**
     * 京东内部sku的id
     */
    private String skuId;

    /**
     * sku外部id（极端情况下不保证返回，建议从商品接口获取
     */
    private String outerSkuId;

    /**
     * 商品的名称+sku规格
     */
    private String skuName;

    /**
     * sku的京东价
     */
    private String jdPrice;

    /**
     * 赠送积分
     */
    private String giftPoint;

    /**
     * 京东内部商品id（极端情况下不保证返回，建议从商品接口获取）
     */
    private String wareid;

    /**
     * 数量
     */
    private String itemTotal;

    private String productNo;

    /**
     * 服务项名称
     */
    private String serviceName;

    /**
     * 订单id
     */
    private Long orderId;


    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getOuterSkuId() {
        return outerSkuId;
    }

    public void setOuterSkuId(String outerSkuId) {
        this.outerSkuId = outerSkuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getJdPrice() {
        return jdPrice;
    }

    public void setJdPrice(String jdPrice) {
        this.jdPrice = jdPrice;
    }

    public String getGiftPoint() {
        return giftPoint;
    }

    public void setGiftPoint(String giftPoint) {
        this.giftPoint = giftPoint;
    }

    public String getWareid() {
        return wareid;
    }

    public void setWareid(String wareid) {
        this.wareid = wareid;
    }

    public String getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(String itemTotal) {
        this.itemTotal = itemTotal;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
