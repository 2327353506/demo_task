package demo.dao.vipmro;

import demo.dao.BaseDao;
import demo.po.SysJobLog;
import demo.vo.Page;

import java.util.List;

/**
 * @author wangmt
 * @date 2017/12/1
 */
public interface SysJobLogDao extends BaseDao<SysJobLog,Long>{


    int findListCount(Page page);

    List<SysJobLog> findList(Page page);
}
