package demo.po.oms;

/**
 * @author wangmt
 * @date 2017/11/28
 */
public class PlatformAliInvoice {

    //id，自增长
    private Long id;

    //订单Id
    private Long orderId;

    //发票类型. 0：普通发票，1:增值税发票
    private int invoiceType;

    //发票公司名称(即发票抬头-title)
    private String invoiceCompanyName;

    //纳税人识别号
    private String taxpayerIdentify;

    //银行账号
    private String registerAccountId;

    //开户银行
    private String registerBank;

    //注册电话
    private String registerPhone;

    //省市区文本
    private String registerCodeText;

    //街道地址
    private String registerStreet;

    //发票收货人
    private String receiveName;

    //发票收货人手机
    private String receiveMobile;

    //发票收货人电话
    private String receivePhone;

    //发票收货地址邮编
    private String receivePost;

    //发票省市区编码对应的文案(增值税发票信息)
    private String receiveCodeText;

    //发票街道地址(增值税发票信息)
    private String receiveStreet;

    //交易id
    private Long tid;


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

    public int getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(int invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceCompanyName() {
        return invoiceCompanyName;
    }

    public void setInvoiceCompanyName(String invoiceCompanyName) {
        this.invoiceCompanyName = invoiceCompanyName;
    }

    public String getTaxpayerIdentify() {
        return taxpayerIdentify;
    }

    public void setTaxpayerIdentify(String taxpayerIdentify) {
        this.taxpayerIdentify = taxpayerIdentify;
    }

    public String getRegisterAccountId() {
        return registerAccountId;
    }

    public void setRegisterAccountId(String registerAccountId) {
        this.registerAccountId = registerAccountId;
    }

    public String getRegisterBank() {
        return registerBank;
    }

    public void setRegisterBank(String registerBank) {
        this.registerBank = registerBank;
    }

    public String getRegisterPhone() {
        return registerPhone;
    }

    public void setRegisterPhone(String registerPhone) {
        this.registerPhone = registerPhone;
    }

    public String getRegisterCodeText() {
        return registerCodeText;
    }

    public void setRegisterCodeText(String registerCodeText) {
        this.registerCodeText = registerCodeText;
    }

    public String getRegisterStreet() {
        return registerStreet;
    }

    public void setRegisterStreet(String registerStreet) {
        this.registerStreet = registerStreet;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveMobile() {
        return receiveMobile;
    }

    public void setReceiveMobile(String receiveMobile) {
        this.receiveMobile = receiveMobile;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceivePost() {
        return receivePost;
    }

    public void setReceivePost(String receivePost) {
        this.receivePost = receivePost;
    }

    public String getReceiveCodeText() {
        return receiveCodeText;
    }

    public void setReceiveCodeText(String receiveCodeText) {
        this.receiveCodeText = receiveCodeText;
    }

    public String getReceiveStreet() {
        return receiveStreet;
    }

    public void setReceiveStreet(String receiveStreet) {
        this.receiveStreet = receiveStreet;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }
}
