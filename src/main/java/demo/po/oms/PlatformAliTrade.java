package demo.po.oms;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangmt
 * @date 2017/11/28
 */
public class PlatformAliTrade {

    //交易id
    private Long id;

    //业务类型。国际站：ta(信保),wholesale(在线批发)。 中文站：普通订单类型 = "cn"; 大额批发订单类型 = "ws"; 普通拿样订单类型 = "yp"; 一分钱拿样订单类型 = "yf"; 倒批(限时折扣)订单类型 = "fs"; 加工定制订单类型 = "cz"; 协议采购订单类型 = "ag"; 伙拼订单类型 = "hp"; 供销订单类型 = "supply"; 淘工厂订单 = "factory"; 快订下单 = "quick"; 享拼订单 = "xiangpin"; 当面付 = "f2f"; 存样服务 = "cyfw"; 代销订单 = "sp"; 微供订单 = "wg";零售通 = "lst";
    private String businessType;

    //创建时间
    private Date createTime;

    //修改时间
    private Date modifyTime;

    //付款时间，如果有多次付款，这里返回的是首次付款时间
    private Date payTime;

    //收货时间，这里返回的是完全收货时间
    private Date receivingTime;

    //完全发货时间
    private Date allDeliveredTime;

    //完成时间
    private Date completeTime;

    //备注，1688指下单时的备注
    private String remark;

    //买家主账号id
    private String buyerId;

    //买家备忘信息
    private String buyerMemo;

    //买家留言
    private String buyerFeedback;

    //卖家主账号id
    private String sellerId;

    //卖家备忘信息
    private String sellerMemo;

    //卖家子账号id，1688无此内容
    private Long sellerSubId;

    //应付款总金额，totalAmount = ∑itemAmount + shippingFee，单位为元
    private BigDecimal totalAmount;

    //运费，单位为元
    private BigDecimal shippingFee;

    //币种，币种，整个交易单使用同一个币种。值范围：USD,RMB,HKD,GBP,CAD,AUD,JPY,KRW,EUR
    private String currency;

    //产品总金额(该订单产品明细表中的产品金额的和)，单位元
    private BigDecimal sumProductPayment;

    //退款金额，单位为元
    private BigDecimal refund;

    //折扣信息
    private String discount;

    //交易状态
    /*订单状态。CANCEL交易关闭，
    SUCCESS交易成功，
    WAIT_BUYER_PAY等待买家付款，
    WAIT_SELLER_SEND等待卖家发货，
    WAIT_BUYER_RECEIVE等待买家确认收货，
    WAIT_SELLER_ACT分阶段等待卖家操作，
    WAIT_BUYER_CONFIRM_ACTION分阶段等待买家确认卖家操作，
    WAIT_SELLER_PUSH分阶段等待卖家推进，
    WAIT_LOGISTICS_TAKE_IN等待物流公司揽件COD，
    WAIT_BUYER_SIGN等待买家签收COD，
    SIGN_IN_SUCCESS买家已签收COD，
    SIGN_IN_FAILED签收失败COD*/
    private String status;

    //是否一次性付款
    private int stepPayall;

    //买家支付宝id
    private String buyerAlipayId;

    //卖家支付宝id
    private String sellerAlipayId;

    //1:担保交易 2:预存款交易 3:ETC境外收单交易 4:即时到帐交易 5:保障金安全交易 6:统一交易流程 7:分阶段付款 8.货到付款交易 9.信用凭证支付交易 10.账期支付交易
    private String tradeType;

    //交易id(字符串格式)
    private String idOfStr;

    //支付宝交易Id
    private String alipayTradeId;

    //确认时间
    private Date confirmedTime;

    //关闭原因
    private String closeReason;

    //收件人
    private String toFullName;

    //收件人移动电话
    private String toMobile;

    //收件人电话
    private String toPhone;

    //邮编
    private String toPost;

    //收货地址（全地址）
    private String toArea;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getReceivingTime() {
        return receivingTime;
    }

    public void setReceivingTime(Date receivingTime) {
        this.receivingTime = receivingTime;
    }

    public Date getAllDeliveredTime() {
        return allDeliveredTime;
    }

    public void setAllDeliveredTime(Date allDeliveredTime) {
        this.allDeliveredTime = allDeliveredTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerMemo() {
        return buyerMemo;
    }

    public void setBuyerMemo(String buyerMemo) {
        this.buyerMemo = buyerMemo;
    }

    public String getBuyerFeedback() {
        return buyerFeedback;
    }

    public void setBuyerFeedback(String buyerFeedback) {
        this.buyerFeedback = buyerFeedback;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerMemo() {
        return sellerMemo;
    }

    public void setSellerMemo(String sellerMemo) {
        this.sellerMemo = sellerMemo;
    }

    public Long getSellerSubId() {
        return sellerSubId;
    }

    public void setSellerSubId(Long sellerSubId) {
        this.sellerSubId = sellerSubId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getSumProductPayment() {
        return sumProductPayment;
    }

    public void setSumProductPayment(BigDecimal sumProductPayment) {
        this.sumProductPayment = sumProductPayment;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStepPayall() {
        return stepPayall;
    }

    public void setStepPayall(int stepPayall) {
        this.stepPayall = stepPayall;
    }

    public String getBuyerAlipayId() {
        return buyerAlipayId;
    }

    public void setBuyerAlipayId(String buyerAlipayId) {
        this.buyerAlipayId = buyerAlipayId;
    }

    public String getSellerAlipayId() {
        return sellerAlipayId;
    }

    public void setSellerAlipayId(String sellerAlipayId) {
        this.sellerAlipayId = sellerAlipayId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getIdOfStr() {
        return idOfStr;
    }

    public void setIdOfStr(String idOfStr) {
        this.idOfStr = idOfStr;
    }

    public String getAlipayTradeId() {
        return alipayTradeId;
    }

    public void setAlipayTradeId(String alipayTradeId) {
        this.alipayTradeId = alipayTradeId;
    }

    public Date getConfirmedTime() {
        return confirmedTime;
    }

    public void setConfirmedTime(Date confirmedTime) {
        this.confirmedTime = confirmedTime;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public String getToFullName() {
        return toFullName;
    }

    public void setToFullName(String toFullName) {
        this.toFullName = toFullName;
    }

    public String getToMobile() {
        return toMobile;
    }

    public void setToMobile(String toMobile) {
        this.toMobile = toMobile;
    }

    public String getToPhone() {
        return toPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    public String getToPost() {
        return toPost;
    }

    public void setToPost(String toPost) {
        this.toPost = toPost;
    }

    public String getToArea() {
        return toArea;
    }

    public void setToArea(String toArea) {
        this.toArea = toArea;
    }


}
