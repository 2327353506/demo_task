package demo.po.oms;

/**
 * @author wangmt
 * @date 2017/11/22
 */

import java.util.Date;

public class PlatformTaobaoTrade {

    //交易编号 (父订单的交易编号)
    private Long tid;

    //同tid
    private String tidStr;

    //卖家昵称
    private String sellerNick;

    //实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private String payment;

    //邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private String postFee;

    //满返红包的金额；如果没有满返红包，则值为 0.00
    private String paidCouponFee;

    //门店自提，总店发货，分店取货的门店自提订单标识
    private String shopPick;

    //使用信用卡支付金额数
    private String creditCardFee;

    //买家昵称
    private String buyerNick;

    //收货人的姓名
    private String receiverName;

    //收货人国籍
    private String receiverCountry;

    //收货人的所在省份
    private String receiverState;

    //收货人的所在城市建议：程序依赖于城市字段做物流等判断的操作，最好加一个判断逻辑：如果返回值里面只有receiver_district参数，该参数作为城市
    private String receiverCity;

    //,收货人的所在地区建议：程序依赖于城市字段做物流等判断的操作，最好加一个判断逻辑：如果返回值里面只有receiver_district参数，该参数作为城市
    private String receiverDistrict;

    //收货人街道地址
    private String receiverTown;

    //收货人的详细地址
    private String receiverAddress;

    //收货人的邮编
    private String receiverZip;

    //收货人的手机号码
    private String receiverMobile;

    //收货人的电话号码
    private String receiverPhone;

    //卖家实际收到的支付宝打款金额（由于子订单可以部分确认收货，这个金额会随着子订单的确认收货而不断增加，交易成功后等于买家实付款减去退款金额）。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private String receivedPayment;

    //发票类型（ 1 电子发票 2 纸质发票 ）
    private String invoiceKind;

    //发票抬头
    private String invoiceName;

    //发票类型
    private String invoiceType;

    //商品购买数量。取值范围：大于零的整数,对于一个trade对应多个order的时候（一笔主订单，对应多笔子订单），num=0，num是一个跟商品关联的属性，一笔订单对应多比子订单的时候，主订单上的num无意义。
    private int num;

    //交易状态。可选值: * TRADE_NO_CREATE_PAY(没有创建支付宝交易) * WAIT_BUYER_PAY(等待买家付款) * SELLER_CONSIGNED_PART(卖家部分发货) * WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款) * WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货) * TRADE_BUYER_SIGNED(买家已签收,货到付款专用) * TRADE_FINISHED(交易成功) * TRADE_CLOSED(付款以后用户退款成功，交易自动关闭) * TRADE_CLOSED_BY_TAOBAO(付款以前，卖家或买家主动关闭交易) * PAY_PENDING(国际信用卡支付付款确认中) * WAIT_PRE_AUTH_CONFIRM(0元购合约中) * PAID_FORBID_CONSIGN(拼团中订单，已付款但禁止发货)
    private String status;

    //交易类型列表，同时查询多种交易类型可用逗号分隔。默认同时查询guarantee_trade, auto_delivery, ec, cod的4种交易类型的数据 可选值 fixed(一口价) auction(拍卖) guarantee_trade(一口价、拍卖) auto_delivery(自动发货) independent_simple_trade(旺店入门版交易) independent_shop_trade(旺店标准版交易) ec(直冲) cod(货到付款) fenxiao(分销) game_equipment(游戏装备) shopex_trade(ShopEX交易) netcn_trade(万网交易) external_trade(统一外部交易)o2o_offlinetrade（O2O交易）step (万人团)nopaid(无付款订单)pre_auth_type(预授权0元购机交易)
    private String type;

    //商品价格。精确到2位小数；单位：元。如：200.07，表示：200元7分
    private String price;

    //可以使用trade.promotion_details查询系统优惠系统优惠金额（如打折，VIP，满就送等），精确到2位小数，单位：元。如：200.07，表示：200元7分
    private String discountFee;

    //商品金额（商品价格乘以数量的总金额）。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private String totalFee;

    //交易创建时间。格式:yyyy-MM-dd HH:mm:ss
    private Date created;

    //付款时间。格式:yyyy-MM-dd HH:mm:ss。订单的付款时间即为物流订单的创建时间。
    private Date payTime;

    //交易修改时间(用户对订单的任何修改都会更新此字段)。格式:yyyy-MM-dd HH:mm:ss
    private Date modified;

    //交易结束时间。交易成功时间(更新交易状态为成功的同时更新)/确认收货时间或者交易关闭时间 。格式:yyyy-MM-dd HH:mm:ss
    private Date endTime;

    //买家留言
    private String buyerMessage;

    //买家备注（与淘宝网上订单的买家备注对应，只有买家才能查看该字段）
    private String buyerMemo;

    //买家备注旗帜（与淘宝网上订单的买家备注旗帜对应，只有买家才能查看该字段）红、黄、绿、蓝、紫 分别对应 1、2、3、4、5
    private int buyerFlag;

    //卖家备注（与淘宝网上订单的卖家备注对应，只有卖家才能查看该字段）
    private String sellerMemo;

    //卖家备注旗帜（与淘宝网上订单的卖家备注旗帜对应，只有卖家才能查看该字段）红、黄、绿、蓝、紫 分别对应 1、2、3、4、5
    private int sellerFlag;

    //创建交易时的物流方式（交易完成前，物流方式有可能改变，但系统里的这个字段一直不变）。可选值：free(卖家包邮),post(平邮),express(快递),ems(EMS),virtual(虚拟发货)，25(次日必达)，26(预约配送)。
    private String shippingType;

    //分阶段付款的订单状态（例如万人团订单等），目前有三返回状态FRONT_NOPAID_FINAL_NOPAID(定金未付尾款未付)，FRONT_PAID_FINAL_NOPAID(定金已付尾款未付)，FRONT_PAID_FINAL_PAID(定金和尾款都付)
    private String stepTradeStatus;

    //分阶段付款的已付金额（万人团订单已付金额）
    private String stepPaidFee;

    //买家货到付款服务费。精确到2位小数;单位:元。如:12.07，表示:12元7分
    private String buyerCodFee;

    //交易内部来源。WAP(手机);HITAO(嗨淘);TOP(TOP平台);TAOBAO(普通淘宝);JHS(聚划算)一笔订单可能同时有以上多个标记，则以逗号分隔
    private String tradeFrom;


    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTidStr() {
        return tidStr;
    }

    public void setTidStr(String tidStr) {
        this.tidStr = tidStr;
    }

    public String getSellerNick() {
        return sellerNick;
    }

    public void setSellerNick(String sellerNick) {
        this.sellerNick = sellerNick;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

    public String getPaidCouponFee() {
        return paidCouponFee;
    }

    public void setPaidCouponFee(String paidCouponFee) {
        this.paidCouponFee = paidCouponFee;
    }

    public String getShopPick() {
        return shopPick;
    }

    public void setShopPick(String shopPick) {
        this.shopPick = shopPick;
    }

    public String getCreditCardFee() {
        return creditCardFee;
    }

    public void setCreditCardFee(String creditCardFee) {
        this.creditCardFee = creditCardFee;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverCountry() {
        return receiverCountry;
    }

    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
    }

    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverTown() {
        return receiverTown;
    }

    public void setReceiverTown(String receiverTown) {
        this.receiverTown = receiverTown;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceivedPayment() {
        return receivedPayment;
    }

    public void setReceivedPayment(String receivedPayment) {
        this.receivedPayment = receivedPayment;
    }

    public String getInvoiceKind() {
        return invoiceKind;
    }

    public void setInvoiceKind(String invoiceKind) {
        this.invoiceKind = invoiceKind;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(String discountFee) {
        this.discountFee = discountFee;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public String getBuyerMemo() {
        return buyerMemo;
    }

    public void setBuyerMemo(String buyerMemo) {
        this.buyerMemo = buyerMemo;
    }

    public int getBuyerFlag() {
        return buyerFlag;
    }

    public void setBuyerFlag(int buyerFlag) {
        this.buyerFlag = buyerFlag;
    }

    public String getSellerMemo() {
        return sellerMemo;
    }

    public void setSellerMemo(String sellerMemo) {
        this.sellerMemo = sellerMemo;
    }

    public int getSellerFlag() {
        return sellerFlag;
    }

    public void setSellerFlag(int sellerFlag) {
        this.sellerFlag = sellerFlag;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public String getStepTradeStatus() {
        return stepTradeStatus;
    }

    public void setStepTradeStatus(String stepTradeStatus) {
        this.stepTradeStatus = stepTradeStatus;
    }

    public String getStepPaidFee() {
        return stepPaidFee;
    }

    public void setStepPaidFee(String stepPaidFee) {
        this.stepPaidFee = stepPaidFee;
    }

    public String getBuyerCodFee() {
        return buyerCodFee;
    }

    public void setBuyerCodFee(String buyerCodFee) {
        this.buyerCodFee = buyerCodFee;
    }

    public String getTradeFrom() {
        return tradeFrom;
    }

    public void setTradeFrom(String tradeFrom) {
        this.tradeFrom = tradeFrom;
    }


}
