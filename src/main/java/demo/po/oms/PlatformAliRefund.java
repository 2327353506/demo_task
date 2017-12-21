package demo.po.oms;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangmt
 * @date 2017/11/28
 */
public class PlatformAliRefund {

    //退款单编号
    private Long id;

    //退款单对应的订单编号
    private Long orderId;

    //售后超时标记
    private int aftersaleAgreeTimeout;

    //售后自动打款
    private int aftersaleAutoDisburse;

    //支付宝交易号
    private String alipayPaymentId;

    //运费的申请退款金额，单位：分
    private BigDecimal applyCarriage;

    //买家原始输入的退款金额(可以为空)
    private BigDecimal applyExpect;

    //买家申请退款金额，单位：分
    private BigDecimal applyPayment;

    //申请原因
    private String applyReason;

    //二级退款原因
    private String applySubReason;

    //买家支付宝ID
    private String buyerAlipayId;

    //买家退货物流公司名
    private String buyerLogisticsName;

    //运单号
    private String freightBill;

    //买家是否已经发货（如果有退货的流程）
    private int buyerSendGoods;

    //买家阿里帐号ID(包括淘宝帐号Id)
    private Long buyerUserId;

    //最大能够退款金额，单位：分
    private BigDecimal canRefundPayment;

    //是否小二修改过退款单
    private int crmModifyRefund;

    //售后退款要求
    private int disputeRequest;

    //纠纷类型：售中退款 售后退款，默认为售中退款
    private int disputeType;

    //实际冻结账户金额,单位：分
    private String frozenFund;

    //申请退款时间
    private Date gmtApply;

    //创建时间
    private Date gmtCreate;

    //修改时间
    private Date gmtModified;

    //完成时间
    private Date gmtCompleted;

    //该退款单超时完成的时间期限
    private Date gmtTimeout;

    //买家是否已收到货
    private int goodsReceived;

    //1：买家未收到货 2：买家已收到货 3：买家已退货
    private int goodsStatus;

    //是否仅退款
    private int onlyRefund;

    //产品名称(退款单关联订单明细的货品名称)
    private String productName;

    //运费的实际退款金额，单位：分
    private BigDecimal refundCarriage;

    //是否要求退货
    private int refundGoods;

    //退款单逻辑主键
    private String refundId;

    //实际退款金额，单位：分
    private BigDecimal refundPayment;

    //卖家拒绝原因
    private String rejectReason;

    //卖家支付宝ID
    private String sellerAlipayId;

    //收货人手机
    private String sellerMobile;

    //收货人姓名
    private String sellerRealName;

    //收货人电话
    private String sellerTel;

    //买家退货时卖家收货地址
    private String sellerReceiveAddress;

    //卖家阿里帐号ID(包括淘宝帐号Id)
    private Long sellerUserId;

    //退款状态
    private String status;

    //是否超时系统冻结，true代表冻结，false代表不冻结
    private int timeoutFreeze;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getAftersaleAgreeTimeout() {
        return aftersaleAgreeTimeout;
    }

    public void setAftersaleAgreeTimeout(int aftersaleAgreeTimeout) {
        this.aftersaleAgreeTimeout = aftersaleAgreeTimeout;
    }

    public int getAftersaleAutoDisburse() {
        return aftersaleAutoDisburse;
    }

    public void setAftersaleAutoDisburse(int aftersaleAutoDisburse) {
        this.aftersaleAutoDisburse = aftersaleAutoDisburse;
    }

    public String getAlipayPaymentId() {
        return alipayPaymentId;
    }

    public void setAlipayPaymentId(String alipayPaymentId) {
        this.alipayPaymentId = alipayPaymentId;
    }

    public BigDecimal getApplyCarriage() {
        return applyCarriage;
    }

    public void setApplyCarriage(BigDecimal applyCarriage) {
        this.applyCarriage = applyCarriage;
    }

    public BigDecimal getApplyExpect() {
        return applyExpect;
    }

    public void setApplyExpect(BigDecimal applyExpect) {
        this.applyExpect = applyExpect;
    }

    public BigDecimal getApplyPayment() {
        return applyPayment;
    }

    public void setApplyPayment(BigDecimal applyPayment) {
        this.applyPayment = applyPayment;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getApplySubReason() {
        return applySubReason;
    }

    public void setApplySubReason(String applySubReason) {
        this.applySubReason = applySubReason;
    }

    public String getBuyerAlipayId() {
        return buyerAlipayId;
    }

    public void setBuyerAlipayId(String buyerAlipayId) {
        this.buyerAlipayId = buyerAlipayId;
    }

    public String getBuyerLogisticsName() {
        return buyerLogisticsName;
    }

    public void setBuyerLogisticsName(String buyerLogisticsName) {
        this.buyerLogisticsName = buyerLogisticsName;
    }

    public String getFreightBill() {
        return freightBill;
    }

    public void setFreightBill(String freightBill) {
        this.freightBill = freightBill;
    }

    public int getBuyerSendGoods() {
        return buyerSendGoods;
    }

    public void setBuyerSendGoods(int buyerSendGoods) {
        this.buyerSendGoods = buyerSendGoods;
    }

    public Long getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(Long buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public BigDecimal getCanRefundPayment() {
        return canRefundPayment;
    }

    public void setCanRefundPayment(BigDecimal canRefundPayment) {
        this.canRefundPayment = canRefundPayment;
    }

    public int getCrmModifyRefund() {
        return crmModifyRefund;
    }

    public void setCrmModifyRefund(int crmModifyRefund) {
        this.crmModifyRefund = crmModifyRefund;
    }

    public int getDisputeRequest() {
        return disputeRequest;
    }

    public void setDisputeRequest(int disputeRequest) {
        this.disputeRequest = disputeRequest;
    }

    public int getDisputeType() {
        return disputeType;
    }

    public void setDisputeType(int disputeType) {
        this.disputeType = disputeType;
    }

    public String getFrozenFund() {
        return frozenFund;
    }

    public void setFrozenFund(String frozenFund) {
        this.frozenFund = frozenFund;
    }

    public Date getGmtApply() {
        return gmtApply;
    }

    public void setGmtApply(Date gmtApply) {
        this.gmtApply = gmtApply;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCompleted() {
        return gmtCompleted;
    }

    public void setGmtCompleted(Date gmtCompleted) {
        this.gmtCompleted = gmtCompleted;
    }

    public Date getGmtTimeout() {
        return gmtTimeout;
    }

    public void setGmtTimeout(Date gmtTimeout) {
        this.gmtTimeout = gmtTimeout;
    }

    public int getGoodsReceived() {
        return goodsReceived;
    }

    public void setGoodsReceived(int goodsReceived) {
        this.goodsReceived = goodsReceived;
    }

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public int getOnlyRefund() {
        return onlyRefund;
    }

    public void setOnlyRefund(int onlyRefund) {
        this.onlyRefund = onlyRefund;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getRefundCarriage() {
        return refundCarriage;
    }

    public void setRefundCarriage(BigDecimal refundCarriage) {
        this.refundCarriage = refundCarriage;
    }

    public int getRefundGoods() {
        return refundGoods;
    }

    public void setRefundGoods(int refundGoods) {
        this.refundGoods = refundGoods;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public BigDecimal getRefundPayment() {
        return refundPayment;
    }

    public void setRefundPayment(BigDecimal refundPayment) {
        this.refundPayment = refundPayment;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getSellerAlipayId() {
        return sellerAlipayId;
    }

    public void setSellerAlipayId(String sellerAlipayId) {
        this.sellerAlipayId = sellerAlipayId;
    }

    public String getSellerMobile() {
        return sellerMobile;
    }

    public void setSellerMobile(String sellerMobile) {
        this.sellerMobile = sellerMobile;
    }

    public String getSellerRealName() {
        return sellerRealName;
    }

    public void setSellerRealName(String sellerRealName) {
        this.sellerRealName = sellerRealName;
    }

    public String getSellerTel() {
        return sellerTel;
    }

    public void setSellerTel(String sellerTel) {
        this.sellerTel = sellerTel;
    }

    public String getSellerReceiveAddress() {
        return sellerReceiveAddress;
    }

    public void setSellerReceiveAddress(String sellerReceiveAddress) {
        this.sellerReceiveAddress = sellerReceiveAddress;
    }

    public Long getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(Long sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTimeoutFreeze() {
        return timeoutFreeze;
    }

    public void setTimeoutFreeze(int timeoutFreeze) {
        this.timeoutFreeze = timeoutFreeze;
    }


}
