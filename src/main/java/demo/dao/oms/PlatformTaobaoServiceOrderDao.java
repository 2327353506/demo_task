package demo.dao.oms;

import demo.po.oms.PlatformTaobaoServiceOrder;

/**
 * @author wangmt
 * @date 2017/11/22
 */
public interface PlatformTaobaoServiceOrderDao {

    void save(PlatformTaobaoServiceOrder trade);

    void update(PlatformTaobaoServiceOrder trade);

    PlatformTaobaoServiceOrder findById(Long id);
}
