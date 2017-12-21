package demo.po.oms;

/**
 * @author wangmt
 * @date 2017/11/28
 */
public class PlatformAliTradeContact {


    private Long id;

    //联系电话
    private String phone;

    //传真
    private String fax;

    //邮箱
    private String email;

    //联系人在平台的IM账号
    private String imInPlatform;

    //联系人名称
    private String name;

    //联系人手机号
    private String mobile;

    //公司名称
    private String companyName;

    //交易id
    private Long tid;

    //联系人类型（1 买家buyer,2 卖家seller）
    private int type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImInPlatform() {
        return imInPlatform;
    }

    public void setImInPlatform(String imInPlatform) {
        this.imInPlatform = imInPlatform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
