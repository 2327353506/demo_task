package demo.po.oms;

/**
 * @author wangmt
 * @date 2017/11/21
 */


public class PlatformTaobaoOrder {

    //子订单编号
    private Long oid;


    private Long tid;

    //订单状态（请关注此状态，如果为TRADE_CLOSED_BY_TAOBAO状态，则不要对此订单进行发货，切记啊！）。可选值: TRADE_NO_CREATE_PAY(没有创建支付宝交易) WAIT_BUYER_PAY(等待买家付款) WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款) WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货) TRADE_BUYER_SIGNED(买家已签收,货到付款专用) TRADE_FINISHED(交易成功) TRADE_CLOSED(付款以后用户退款成功，交易自动关闭) TRADE_CLOSED_BY_TAOBAO(付款以前，卖家或买家主动关闭交易)PAY_PENDING(国际信用卡支付付款确认中)
    private String status;

    //套餐的值。如：M8原装电池:便携支架:M8专用座充:莫凡保护袋
    private String itemMealName;

    //商品图片的绝对路径
    private String picPath;

    //退款状态。退款状态。可选值 WAIT_SELLER_AGREE(买家已经申请退款，等待卖家同意) WAIT_BUYER_RETURN_GOODS(卖家已经同意退款，等待买家退货) WAIT_SELLER_CONFIRM_GOODS(买家已经退货，等待卖家确认收货) SELLER_REFUSE_BUYER(卖家拒绝退款) CLOSED(退款关闭) SUCCESS(退款成功)
    private String refundStatus;

    //商家外部编码(可与商家外部系统对接)。外部商家自己定义的商品Item的id，可以通过taobao.items.custom.get获取商品的Item的信息
    private String outerIid;

    //订单快照URL
    private String snapshotUrl;

    //卖家类型，可选值为：B（商城商家），C（普通卖家）
    private String sellerType;

    //交易商品对应的类目ID
    private Long cid;

    //商品标题
    private String title;

    //交易类型
    private String type;

    //商品的字符串编号(注意：iid近期即将废弃，请用num_iid参数)
    private Long numIid;

    //商品价格。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private String price;

    //套餐ID
    private Long itemMealId;

    //商品的最小库存单位Sku的id.可以通过taobao.item.sku.get获取详细的Sku信息
    private String skuId;

    //购买数量。取值范围:大于零的整数
    private int num;

    //外部网店自己定义的Sku编号
    private String outerSkuId;

    //子订单来源,如jhs(聚划算)、taobao(淘宝)、wap(无线)
    private String orderFrom;

    //应付金额（商品价格 * 商品数量 + 手工调整金额 - 子订单级订单优惠金额）。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private String totalFee;

    //子订单实付金额。精确到2位小数，单位:元。如:200.07，表示:200元7分。对于多子订单的交易，计算公式如下：payment = price * num + adjust_fee - discount_fee ；单子订单交易，payment与主订单的payment一致，对于退款成功的子订单，由于主订单的优惠分摊金额，会造成该字段可能不为0.00元。建议使用退款前的实付金额减去退款单中的实际退款金额计算。
    private String payment;

    //子订单级订单优惠金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private String discountFee;

    //SKU的值。如：机身颜色:黑色;手机套餐:官方标配
    private String skuPropertiesName;

    //最近退款ID
    private Long refundId;

    //是否超卖
    private int isOversold;

    //是否是服务订单，是返回true，否返回false。
    private int isServiceOrder;

    //表示订单交易是否含有对应的代销采购单。如果该订单中存在一个对应的代销采购单，那么该值为true；反之，该值为false。
    private int isDaixiao;

    //分摊之后的实付金额
    private String divideOrderFee;

    //优惠分摊
    private String partMjzDiscount;

    //支持家装类物流的类型
    private String tmserSpuCode;

    //库存类型：6为在途
    private String invType;

    //是否发货
    private int isShShip;

    //主商品订单id
    private String assemblyRela;

    //价格
    private String assemblyPrice;

    //花呗分期期数
    private int fqgNum;

    //个人充值红包金额
    private String rechargeFee;


    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getItemMealName() {
        return itemMealName;
    }

    public void setItemMealName(String itemMealName) {
        this.itemMealName = itemMealName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getOuterIid() {
        return outerIid;
    }

    public void setOuterIid(String outerIid) {
        this.outerIid = outerIid;
    }

    public String getSnapshotUrl() {
        return snapshotUrl;
    }

    public void setSnapshotUrl(String snapshotUrl) {
        this.snapshotUrl = snapshotUrl;
    }

    public String getSellerType() {
        return sellerType;
    }

    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getItemMealId() {
        return itemMealId;
    }

    public void setItemMealId(Long itemMealId) {
        this.itemMealId = itemMealId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getOuterSkuId() {
        return outerSkuId;
    }

    public void setOuterSkuId(String outerSkuId) {
        this.outerSkuId = outerSkuId;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(String discountFee) {
        this.discountFee = discountFee;
    }

    public String getSkuPropertiesName() {
        return skuPropertiesName;
    }

    public void setSkuPropertiesName(String skuPropertiesName) {
        this.skuPropertiesName = skuPropertiesName;
    }

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public int getIsOversold() {
        return isOversold;
    }

    public void setIsOversold(int isOversold) {
        this.isOversold = isOversold;
    }

    public int getIsServiceOrder() {
        return isServiceOrder;
    }

    public void setIsServiceOrder(int isServiceOrder) {
        this.isServiceOrder = isServiceOrder;
    }

    public int getIsDaixiao() {
        return isDaixiao;
    }

    public void setIsDaixiao(int isDaixiao) {
        this.isDaixiao = isDaixiao;
    }

    public String getDivideOrderFee() {
        return divideOrderFee;
    }

    public void setDivideOrderFee(String divideOrderFee) {
        this.divideOrderFee = divideOrderFee;
    }

    public String getPartMjzDiscount() {
        return partMjzDiscount;
    }

    public void setPartMjzDiscount(String partMjzDiscount) {
        this.partMjzDiscount = partMjzDiscount;
    }

    public String getTmserSpuCode() {
        return tmserSpuCode;
    }

    public void setTmserSpuCode(String tmserSpuCode) {
        this.tmserSpuCode = tmserSpuCode;
    }

    public String getInvType() {
        return invType;
    }

    public void setInvType(String invType) {
        this.invType = invType;
    }

    public int getIsShShip() {
        return isShShip;
    }

    public void setIsShShip(int isShShip) {
        this.isShShip = isShShip;
    }

    public String getAssemblyRela() {
        return assemblyRela;
    }

    public void setAssemblyRela(String assemblyRela) {
        this.assemblyRela = assemblyRela;
    }

    public String getAssemblyPrice() {
        return assemblyPrice;
    }

    public void setAssemblyPrice(String assemblyPrice) {
        this.assemblyPrice = assemblyPrice;
    }

    public int getFqgNum() {
        return fqgNum;
    }

    public void setFqgNum(int fqgNum) {
        this.fqgNum = fqgNum;
    }

    public String getRechargeFee() {
        return rechargeFee;
    }

    public void setRechargeFee(String rechargeFee) {
        this.rechargeFee = rechargeFee;
    }


}