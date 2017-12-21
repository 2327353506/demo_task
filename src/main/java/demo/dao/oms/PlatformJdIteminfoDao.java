package demo.dao.oms;

import demo.po.oms.PlatformJdIteminfo;

/**
 * @author wangmt
 * @date 2017/11/15
 */
public interface PlatformJdIteminfoDao {

    <T> void save(T t);

    <T> void update(T t);

    PlatformJdIteminfo findById(String id);

}
