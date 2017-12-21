package demo.dao.oms;

import demo.po.oms.PlatformTaobaoPromotion;

/**
 * @author wangmt
 * @date 2017/11/22
 */
public interface PlatformTaobaoPromotionDao {

    void save(PlatformTaobaoPromotion trade);

    void update(PlatformTaobaoPromotion trade);

    PlatformTaobaoPromotion findById(Long id);
}
