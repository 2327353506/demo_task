package demo.po.oms;

import java.math.BigDecimal;

/**
 * @author wangmt
 * @date 2017/11/22
 */
public class PlatformTaobaoServiceOrder {

    //虚拟服务子订单订单号
    private Long oid;


    private Long tid;

    //服务所属的交易订单号。如果服务为一年包换，则item_oid这笔订单享受改服务的保护
    private Long itemOid;

    //服务数字id
    private Long serviceId;

    //服务详情的URL地址
    private String serviceDetailUrl;

    //购买数量，取值范围为大于0的整数
    private int num;

    //服务价格，精确到小数点后两位：单位:元
    private BigDecimal price;

    //子订单实付金额。精确到2位小数，单位:元。如:200.07，表示:200元7分。
    private BigDecimal payment;

    //商品名称
    private String title;

    //服务子订单总费用
    private BigDecimal totalFee;

    //买家昵称
    private String buyerNick;

    //最近退款的id
    private Long refundId;

    //卖家昵称
    private String sellerNick;

    //服务图片地址
    private String picPath;

    //支持家装类物流的类型
    private String tmserSpuCode;

    //虚拟服务子订单订单号(varchar(100)类型)
    private String oidStr;


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

    public Long getItemOid() {
        return itemOid;
    }

    public void setItemOid(Long itemOid) {
        this.itemOid = itemOid;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceDetailUrl() {
        return serviceDetailUrl;
    }

    public void setServiceDetailUrl(String serviceDetailUrl) {
        this.serviceDetailUrl = serviceDetailUrl;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public String getSellerNick() {
        return sellerNick;
    }

    public void setSellerNick(String sellerNick) {
        this.sellerNick = sellerNick;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getTmserSpuCode() {
        return tmserSpuCode;
    }

    public void setTmserSpuCode(String tmserSpuCode) {
        this.tmserSpuCode = tmserSpuCode;
    }

    public String getOidStr() {
        return oidStr;
    }

    public void setOidStr(String oidStr) {
        this.oidStr = oidStr;
    }


}