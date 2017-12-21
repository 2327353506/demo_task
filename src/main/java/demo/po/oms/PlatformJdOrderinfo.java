package demo.po.oms;

/**
 * @author wangmt
 * @date 2017/11/15
 */


public class PlatformJdOrderinfo {

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 商家id
     */
    private String venderId;

    /**
     * 订单类型（22 sop； 75 loc） 可选字段，需要在输入参数optional_fields中写入才能返回
     */
    private String orderType;

    /**
     * 支付方式（1货到付款, 2邮局汇款, 3自提, 4在线支付, 5公司转账, 6银行卡转账）
     */
    private String payType;

    /**
     * 订单总金额
     */
    private String orderTotalPrice;

    /**
     * 订单货款金额（订单总金额-商家优惠金额）
     */
    private String orderSellerPrice;

    /**
     * 用户应付金额
     */
    private String orderPayment;

    /**
     * 商品的运费
     */
    private String freightPrice;

    /**
     * 商家优惠金额
     */
    private String sellerDiscount;

    /**
     * 订单状态（英文）
     */
    private String orderState;

    /**
     * 订单状态说明（中文）
     */
    private String orderStateRemark;

    /**
     * 送货（日期）类型（1-只工作日送货(双休日、假日不用送);2-只双休日、假日送货(工作日不用送);3-工作日、双休日与假日均可送货;其他值-返回“任意时间”）
     */
    private String deliveryType;

    /**
     * 发票信息 “invoice_info: 不需要开具发票”下无需开具发票；其它返回值请正常开具发票
     */
    private String invoiceInfo;

    /**
     * 普通发票纳税人识别码
     */
    private String invoiceCode;

    /**
     * 买家下单时订单备注
     */
    private String orderRemark;

    /**
     * 下单时间
     */
    private String orderStartTime;

    /**
     * 结单时间 如返回信息为，可认为此订单为未完成状态。
     */
    private String orderEndTime;

    /**
     * 商家订单备注（不大于500字符） 可选字段，需要在输入参数optional_fields中写入才能返回
     */
    private String venderRemark;

    /**
     * 余额支付金额 可选字段，需要在输入参数optional_fields中写入才能返回
     */
    private String balanceUsed;

    /**
     * 买家的账号信息 可选字段，需要在输入参数optional_fields中写入才能返回
     */
    private String pin;

    /**
     * 售后订单标记 0:不是换货订单 1返修发货,直接赔偿,客服补件 2售后调货 可选字段，需要在输入参数optional_fields中写入才能返回
     */
    private String returnOrder;

    /**
     * 付款确认时间 如果没有付款时间 默认返回0001-01-01 00:00:00 可选字段，需要在输入参数optional_fields中写入才能返回
     */
    private String paymentConfirmTime;

    /**
     * 运单号(当厂家自送时运单号可为空，不同物流公司的运单号用|分隔，如果同一物流公司有多个运单号，则用英文逗号分隔) 可选字段，需要在输入参数optional_fields中写入才能返回
     */
    private String waybill;

    /**
     * 物流公司id 可选字段，需要在输入参数optional_fields中写入才能返回
     */
    private String logisticsid;

    /**
     * 订单更新时间
     */
    private String modified;

    /**
     * 直接父订单号 可选字段，需要在输入参数optional_fields中写入才能返回
     */
    private String directParentOrderid;

    /**
     * 根父订单号 可选字段，需要在输入参数optional_fields中写入才能返回
     */
    private String parentOrderid;

    /**
     * 保税区信息
     */
    private String customs;

    /**
     * 保税模型：直邮，保税集货，保税备货
     */
    private String customsModel;

    /**
     * 订单来源
     */
    private String orderSource;

    /**
     * 京仓订单.如果是京仓订单，结果返回文字“京仓订单”；否则返回结果为空值
     */
    private String storeOrder;

    /**
     * 是否京配
     */
    private Integer idsopShipmenttype;

    /**
     * 最早生产时间
     */
    private String scdt;

    /**
     * 服务费
     */
    private String serviceFee;

    /**
     * 税价分离 税费
     */
    private String taxFee;

    /**
     * 退货无忧
     */
    private String tuihuowuyou;

    /**
     * sendpay
     */
    private String orderSign;

    /**
     * 仓库id
     */
    private String storeId;

    private Long userinfoId;

    private Long vatinfoId;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getOrderSellerPrice() {
        return orderSellerPrice;
    }

    public void setOrderSellerPrice(String orderSellerPrice) {
        this.orderSellerPrice = orderSellerPrice;
    }

    public String getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(String orderPayment) {
        this.orderPayment = orderPayment;
    }

    public String getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(String freightPrice) {
        this.freightPrice = freightPrice;
    }

    public String getSellerDiscount() {
        return sellerDiscount;
    }

    public void setSellerDiscount(String sellerDiscount) {
        this.sellerDiscount = sellerDiscount;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderStateRemark() {
        return orderStateRemark;
    }

    public void setOrderStateRemark(String orderStateRemark) {
        this.orderStateRemark = orderStateRemark;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getInvoiceInfo() {
        return invoiceInfo;
    }

    public void setInvoiceInfo(String invoiceInfo) {
        this.invoiceInfo = invoiceInfo;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public String getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(String orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    public String getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(String orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public String getVenderRemark() {
        return venderRemark;
    }

    public void setVenderRemark(String venderRemark) {
        this.venderRemark = venderRemark;
    }

    public String getBalanceUsed() {
        return balanceUsed;
    }

    public void setBalanceUsed(String balanceUsed) {
        this.balanceUsed = balanceUsed;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getReturnOrder() {
        return returnOrder;
    }

    public void setReturnOrder(String returnOrder) {
        this.returnOrder = returnOrder;
    }

    public String getPaymentConfirmTime() {
        return paymentConfirmTime;
    }

    public void setPaymentConfirmTime(String paymentConfirmTime) {
        this.paymentConfirmTime = paymentConfirmTime;
    }

    public String getWaybill() {
        return waybill;
    }

    public void setWaybill(String waybill) {
        this.waybill = waybill;
    }

    public String getLogisticsid() {
        return logisticsid;
    }

    public void setLogisticsid(String logisticsid) {
        this.logisticsid = logisticsid;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getDirectParentOrderid() {
        return directParentOrderid;
    }

    public void setDirectParentOrderid(String directParentOrderid) {
        this.directParentOrderid = directParentOrderid;
    }

    public String getParentOrderid() {
        return parentOrderid;
    }

    public void setParentOrderid(String parentOrderid) {
        this.parentOrderid = parentOrderid;
    }

    public String getCustoms() {
        return customs;
    }

    public void setCustoms(String customs) {
        this.customs = customs;
    }

    public String getCustomsModel() {
        return customsModel;
    }

    public void setCustomsModel(String customsModel) {
        this.customsModel = customsModel;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getStoreOrder() {
        return storeOrder;
    }

    public void setStoreOrder(String storeOrder) {
        this.storeOrder = storeOrder;
    }

    public Integer getIdsopShipmenttype() {
        return idsopShipmenttype;
    }

    public void setIdsopShipmenttype(Integer idsopShipmenttype) {
        this.idsopShipmenttype = idsopShipmenttype;
    }

    public String getScdt() {
        return scdt;
    }

    public void setScdt(String scdt) {
        this.scdt = scdt;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(String taxFee) {
        this.taxFee = taxFee;
    }

    public String getTuihuowuyou() {
        return tuihuowuyou;
    }

    public void setTuihuowuyou(String tuihuowuyou) {
        this.tuihuowuyou = tuihuowuyou;
    }

    public String getOrderSign() {
        return orderSign;
    }

    public void setOrderSign(String orderSign) {
        this.orderSign = orderSign;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Long getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(Long userinfoId) {
        this.userinfoId = userinfoId;
    }

    public Long getVatinfoId() {
        return vatinfoId;
    }

    public void setVatinfoId(Long vatinfoId) {
        this.vatinfoId = vatinfoId;
    }


}
