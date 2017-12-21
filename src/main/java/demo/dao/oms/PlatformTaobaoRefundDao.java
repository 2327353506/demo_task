package demo.dao.oms;

import demo.po.oms.PlatformTaobaoRefund;

/**
 * @author wangmt
 * @date 2017/11/23
 */
public interface PlatformTaobaoRefundDao {

    void save(PlatformTaobaoRefund trade);

    void update(PlatformTaobaoRefund trade);

    PlatformTaobaoRefund findById(Long id);
}
