package demo.service.impl;

import demo.dao.vipmro.SysJobLogDao;
import demo.service.ErrorCentreService;
import demo.vo.TaskJobVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmt
 * @date 2017/12/1
 */
@Service
public class ErrorCentreServiceImpl implements ErrorCentreService{

    @Autowired
    private SysJobLogDao sysJobLogDao;

    /**
     * 查看日志记录列表
     *
     * @param vo
     * @return
     */
    @Override
    public Map findList(TaskJobVo vo) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows",sysJobLogDao.findList(vo));
        map.put("total",sysJobLogDao.findListCount(vo));
        return map;
    }
}
