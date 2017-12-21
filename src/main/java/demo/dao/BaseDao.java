package demo.dao;

import demo.po.oms.PlatformAliRefund;

/**
 * @author wangmt
 * @date 2017/11/28
 */
public interface BaseDao<T,E> {

    int save(T t);

    int update(T t);

    T findById(E id);

}
