package demo.po.oms;

/**
 * @author wangmt
 * @date 2017/11/15
 */
public class PlatformJdVatinfo {

    private Long id;

    /**
     * 纳税人识别号
     */
    private String vatno;

    /**
     * 注册地址
     */
    private String addressRegistered;

    /**
     * 注册电话
     */
    private String phoneRegistered;

    /**
     * 开户银行
     */
    private String depositBank;

    /**
     * 银行账户
     */
    private String bankAccount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVatno() {
        return vatno;
    }

    public void setVatno(String vatno) {
        this.vatno = vatno;
    }

    public String getAddressRegistered() {
        return addressRegistered;
    }

    public void setAddressRegistered(String addressRegistered) {
        this.addressRegistered = addressRegistered;
    }

    public String getPhoneRegistered() {
        return phoneRegistered;
    }

    public void setPhoneRegistered(String phoneRegistered) {
        this.phoneRegistered = phoneRegistered;
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

}
