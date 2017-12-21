package demo.dao.oms;

import demo.po.oms.PlatformJdCoupon;

/**
 * @author wangmt
 * @date 2017/11/15
 */
public interface PlatformJdCouponDao {

    <T> void save(T t);

    <T> void update(T t);

    PlatformJdCoupon findById(String id);
}
