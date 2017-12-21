package demo.dao.oms;

import demo.po.oms.PlatformTaobaoOrder;

/**
 * @author wangmt
 * @date 2017/11/22
 */
public interface PlatformTaobaoOrderDao {

    void save(PlatformTaobaoOrder trade);

    void update(PlatformTaobaoOrder trade);

    PlatformTaobaoOrder findById(Long id);
}
