package demo.dao.oms;

import demo.po.oms.PlatformJdOrderinfo;

/**
 * @author wangmt
 * @date 2017/11/15
 */
public interface PlatformJdOrderinfoDao {

    <T> void save(T t);

    <T> void update(T t);

    PlatformJdOrderinfo findById(Long id);
}
