package demo.dao.oms;

import demo.po.oms.PlatformTaobaoTrade;

/**
 * @author wangmt
 * @date 2017/11/22
 */
public interface PlatformTaobaoTradeDao {

    void save(PlatformTaobaoTrade trade);

    void update(PlatformTaobaoTrade trade);

    PlatformTaobaoTrade findById(Long id);
}
