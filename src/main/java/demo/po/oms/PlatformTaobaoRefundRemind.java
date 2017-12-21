package demo.po.oms;

import java.util.Date;

/**
 * @author wangmt
 * @date 2017/11/23
 */
public class PlatformTaobaoRefundRemind {


    private int id;

    //提醒的类型（退款详情中提示信息的类型）
    private int remindType;

    //是否存在超时。可选值:true(是),false(否)
    private int existTimeout;

    //超时时间。格式:yyyy-MM-dd HH:mm:ss
    private Date timeout;


    private Long refundId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRemindType() {
        return remindType;
    }

    public void setRemindType(int remindType) {
        this.remindType = remindType;
    }

    public int getExistTimeout() {
        return existTimeout;
    }

    public void setExistTimeout(int existTimeout) {
        this.existTimeout = existTimeout;
    }

    public Date getTimeout() {
        return timeout;
    }

    public void setTimeout(Date timeout) {
        this.timeout = timeout;
    }

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }


}
