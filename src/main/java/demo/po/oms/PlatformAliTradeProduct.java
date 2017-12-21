package demo.po.oms;

import java.math.BigDecimal;

/**
 * @author wangmt
 * @date 2017/11/28
 */
public class PlatformAliTradeProduct {

    //指定单品货号，国际站无需关注。该字段不一定有值，仅仅在下单时才会把货号记录(如果卖家设置了单品货号的话)。别的订单类型的货号只能通过商品接口去获取。请注意：通过商品接口获取时的货号和下单时的货号可能不一致，因为下单完成后卖家可能修改商品信息，改变了货号。
    //外部编码关联用
    private String cargoNumber;

    //'指定商品货号，该字段不一定有值，在下单时才会把货号记录。别的订单类型的货号只能通过商品接口去获取。请注意：通过商品接口获取时的货号和下单时的货号可能不一致，因为下单完成后卖家可能修改商品信息，改变了货号。该字段和cargoNUmber的区别是：该字段是定义在商品级别上的货号，cargoNUmber是定义在单品级别的货号
    //外部编码关联用，没有cargoNumber则取该值
    private String productCargoNumber;

    //描述,1688无此信息
    private String description;

    //实付金额，单位为元
    private BigDecimal itemAmount;

    //商品名称
    private String name;

    //原始单价，以元为单位
    private BigDecimal price;

    //产品ID（非在线产品为空）
    private Long productId;

    //商品图片url
    private String productImgUrl;

    //产品快照url，交易订单产生时会自动记录下当时的商品快照，供后续纠纷时参考
    private String productSnapshotUrl;

    //以unit为单位的数量，例如多少个、多少件、多少箱、多少吨
    private BigDecimal quantity;

    //退款金额，单位为元
    private BigDecimal refund;

    //skuID
    private Long skuId;

    //子订单状态
    private String status;

    //商品明细条目ID
    private Long subitemId;

    //售卖单位 例如：个、件、箱、吨
    private String unit;

    //重量 按重量单位计算的重量，例如：100
    private BigDecimal weight;

    //重量单位 例如：g，kg，t
    private String weightUnit;

    //交易id
    private Long tid;


    public String getCargoNumber() {
        return cargoNumber;
    }

    public void setCargoNumber(String cargoNumber) {
        this.cargoNumber = cargoNumber;
    }

    public String getProductCargoNumber() {
        return productCargoNumber;
    }

    public void setProductCargoNumber(String productCargoNumber) {
        this.productCargoNumber = productCargoNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(BigDecimal itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductImgUrl() {
        return productImgUrl;
    }

    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }

    public String getProductSnapshotUrl() {
        return productSnapshotUrl;
    }

    public void setProductSnapshotUrl(String productSnapshotUrl) {
        this.productSnapshotUrl = productSnapshotUrl;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSubitemId() {
        return subitemId;
    }

    public void setSubitemId(Long subitemId) {
        this.subitemId = subitemId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }


}
