package demo.po.oms;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangmt
 * @date 2017/11/23
 */
public class PlatformTaobaoRefund {

    //退款单号
    private Long refundId;

    //物流方式.可选值:free(卖家包邮),post(平邮),express(快递),ems(EMS).
    private String shippingType;

    //不需客服介入1;需要客服介入2;客服已经介入3;客服初审完成 4;客服主管复审失败5;客服处理完成6;
    private int csStatus;

    //退款先行垫付默认的未申请状态 0;退款先行垫付申请中 1;退款先行垫付，垫付完成 2;退款先行垫付，卖家拒绝收货 3;退款先行垫付，垫付关闭 4;退款先行垫付，垫付分账成功 5;
    private int advanceStatus;

    //分账给淘宝的钱
    private BigDecimal splitTaobaoFee;

    //分账给卖家的钱
    private BigDecimal splitSellerFee;

    //淘宝交易单号
    private Long tid;

    //子订单号。如果是单笔交易oid会等于tid
    private Long oid;

    //支付宝交易号
    private String alipayNo;

    //交易总金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private BigDecimal totalFee;

    //买家昵称
    private String buyerNick;

    //卖家昵称
    private String sellerNick;

    //退款申请时间。格式:yyyy-MM-dd HH:mm:ss
    private Date created;

    //更新时间。格式:yyyy-MM-dd HH:mm:ss
    private Date modified;

    //退款对应的订单交易状态。可选值TRADE_NO_CREATE_PAY(没有创建支付宝交易) WAIT_BUYER_PAY(等待买家付款) WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款) WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货) TRADE_BUYER_SIGNED(买家已签收,货到付款专用) TRADE_FINISHED(交易成功) TRADE_CLOSED(交易关闭) TRADE_CLOSED_BY_TAOBAO(交易被淘宝关闭) ALL_WAIT_PAY(包含：WAIT_BUYER_PAY、TRADE_NO_CREATE_PAY) ALL_CLOSED(包含：TRADE_CLOSED、TRADE_CLOSED_BY_TAOBAO) 取自"http://open.taobao.com/dev/index.php/%E4%BA%A4%E6%98%93%E7%8A%B6%E6%80%81"
    private String orderStatus;

    //退款状态。可选值WAIT_SELLER_AGREE(买家已经申请退款，等待卖家同意) WAIT_BUYER_RETURN_GOODS(卖家已经同意退款，等待买家退货) WAIT_SELLER_CONFIRM_GOODS(买家已经退货，等待卖家确认收货) SELLER_REFUSE_BUYER(卖家拒绝退款) CLOSED(退款关闭) SUCCESS(退款成功)
    private String status;

    //货物状态。可选值BUYER_NOT_RECEIVED (买家未收到货) BUYER_RECEIVED (买家已收到货) BUYER_RETURNED_GOODS (买家已退货)
    private String goodStatus;

    //买家是否需要退货。可选值:true(是),false(否)
    private int hasGoodReturn;

    //退还金额(退还给买家的金额)。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private BigDecimal refundFee;

    //支付给卖家的金额(交易总金额-退还给买家的金额)。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private BigDecimal payment;

    //退款原因
    private String reason;

    //退款说明
    private String desc;

    //商品标题
    private String title;

    //商品价格。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private BigDecimal price;

    //商品购买数量
    private int num;

    //退货时间。格式:yyyy-MM-dd HH:mm:ss
    private Date goodReturnTime;

    //物流公司名称
    private String companyName;

    //退货运单号
    private String sid;

    //卖家收货地址
    private String address;

    //申请退款的商品数字编号
    private Long numIid;

    //退款阶段，可选值：onsale/aftersale
    private String refundPhase;

    //退款版本号（时间戳）
    private Long refundVersion;

    //商品SKU信息
    private String sku;

    //退款扩展属性
    private String attribute;

    //商品外部商家编码
    private String outerId;

    //退款约束，可选值：cannot_refuse（不允许操作），refund_onweb（需要到网页版操作）
    private String operationContraint;


    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public int getCsStatus() {
        return csStatus;
    }

    public void setCsStatus(int csStatus) {
        this.csStatus = csStatus;
    }

    public int getAdvanceStatus() {
        return advanceStatus;
    }

    public void setAdvanceStatus(int advanceStatus) {
        this.advanceStatus = advanceStatus;
    }

    public BigDecimal getSplitTaobaoFee() {
        return splitTaobaoFee;
    }

    public void setSplitTaobaoFee(BigDecimal splitTaobaoFee) {
        this.splitTaobaoFee = splitTaobaoFee;
    }

    public BigDecimal getSplitSellerFee() {
        return splitSellerFee;
    }

    public void setSplitSellerFee(BigDecimal splitSellerFee) {
        this.splitSellerFee = splitSellerFee;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getAlipayNo() {
        return alipayNo;
    }

    public void setAlipayNo(String alipayNo) {
        this.alipayNo = alipayNo;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public String getSellerNick() {
        return sellerNick;
    }

    public void setSellerNick(String sellerNick) {
        this.sellerNick = sellerNick;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(String goodStatus) {
        this.goodStatus = goodStatus;
    }

    public int getHasGoodReturn() {
        return hasGoodReturn;
    }

    public void setHasGoodReturn(int hasGoodReturn) {
        this.hasGoodReturn = hasGoodReturn;
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getGoodReturnTime() {
        return goodReturnTime;
    }

    public void setGoodReturnTime(Date goodReturnTime) {
        this.goodReturnTime = goodReturnTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getRefundPhase() {
        return refundPhase;
    }

    public void setRefundPhase(String refundPhase) {
        this.refundPhase = refundPhase;
    }

    public Long getRefundVersion() {
        return refundVersion;
    }

    public void setRefundVersion(Long refundVersion) {
        this.refundVersion = refundVersion;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getOperationContraint() {
        return operationContraint;
    }

    public void setOperationContraint(String operationContraint) {
        this.operationContraint = operationContraint;
    }


}