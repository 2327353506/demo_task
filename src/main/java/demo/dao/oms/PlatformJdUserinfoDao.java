package demo.dao.oms;

import demo.po.oms.PlatformJdUserinfo;

/**
 * @author wangmt
 * @date 2017/11/15
 */
public interface PlatformJdUserinfoDao {

    <T> void save(T t);

    <T> void update(T t);

    PlatformJdUserinfo findById(String id);
}
