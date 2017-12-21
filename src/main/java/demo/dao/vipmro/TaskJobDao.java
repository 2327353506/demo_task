package demo.dao.vipmro;

import demo.po.TaskJob;
import demo.vo.TaskJobVo;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @author wangmt
 * @date 2017/11/14
 */
@MapperScan
public interface TaskJobDao {

    List findTaskList(TaskJobVo vo);

    int findTaskListCount(TaskJobVo vo);

    List findTaskAll();

    TaskJob findTaskById(String id);

    void updateTaskStatus(@Param("id")String id, @Param("code") int code);

    void updateTask(TaskJobVo vo);

    void saveTask(TaskJobVo vo);

    List findEnableTask();

    List<TaskJob> findTaskByClass(@Param("clazz")String clazz);
}
