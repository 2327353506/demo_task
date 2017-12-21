package demo.dao.oms;

import demo.po.oms.PlatformJdVatinfo;

/**
 * @author wangmt
 * @date 2017/11/15
 */
public interface PlatformJdVatinfoDao {

    <T> void save(T t);

    <T> void update(T t);

    PlatformJdVatinfo findById(String id);
}
