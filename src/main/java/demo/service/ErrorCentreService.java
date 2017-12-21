package demo.service;

import demo.vo.TaskJobVo;

import java.util.Map;

/**
 * @author wangmt
 * @date 2017/12/1
 */
public interface ErrorCentreService {
    /**
     * 查看日志记录列表
     * @param vo
     * @return
     */
    Map findList(TaskJobVo vo);
}
