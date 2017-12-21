package demo.service;

import demo.po.SysJobLog;
import demo.po.TaskJob;
import demo.vo.TaskJobVo;

import java.util.List;
import java.util.Map;

/**
 * @author wangmt
 * @date 2017/11/14
 */
public interface TaskJobService {

    List<TaskJob> getTaskList();

    Map<String,Object> findTaskList(TaskJobVo vo);

    void openTask(String id);

    void stopTask(String id);

    void saveTask(TaskJobVo vo);

    void delTask(String id);

    TaskJob findTask(String id);

    void stopTaskByClass(String clazz);

    void saveJobLog(SysJobLog log);

    void updateJobLog(SysJobLog log);
}
