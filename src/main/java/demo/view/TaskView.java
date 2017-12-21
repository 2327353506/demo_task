package demo.view;

import com.alibaba.fastjson.JSONObject;
import demo.po.TaskJob;
import demo.service.TaskJobService;
import demo.vo.ResponseMsg;
import demo.vo.TaskJobVo;
import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmt
 * @date 2017/11/14
 */
@Controller
@RequestMapping("task")
public class TaskView {

    @Autowired
    private TaskJobService taskJobService;
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @RequestMapping(value = "list")
    @ResponseBody
    public ResponseMsg getTaskList(TaskJobVo vo){
        ResponseMsg res = new ResponseMsg();
        try{
            res.setData(taskJobService.findTaskList(vo));
        }catch (Exception e){
            res.setError(e);
        }
        return res;
    }

    @RequestMapping(value = "/open")
    @ResponseBody
    public ResponseMsg openTask(String id){
        ResponseMsg res = new ResponseMsg();
        try{
            taskJobService.openTask(id);
        }catch (Exception e){
            res.setError(e);
        }
        return res;
    }
    @RequestMapping(value = "/stop")
    @ResponseBody
    public ResponseMsg stopTask(String id){
        ResponseMsg res = new ResponseMsg();
        try{
            taskJobService.stopTask(id);
        }catch (Exception e){
            res.setError(e);
        }
        return res;
    }
    @RequestMapping(value = "/del")
    @ResponseBody
    public ResponseMsg delTask(String id){
        ResponseMsg res = new ResponseMsg();
        try{
            taskJobService.delTask(id);
        }catch (Exception e){
            res.setError(e);
        }
        return res;
    }
    @RequestMapping(value = "/save")
    @ResponseBody
    public ResponseMsg saveTask(TaskJobVo vo){
        ResponseMsg res = new ResponseMsg();
        try{
            taskJobService.saveTask(vo);
        }catch (Exception e){
            res.setError(e);
        }
        return res;
    }

    @RequestMapping(value = "/detail")
    @ResponseBody
    public ResponseMsg findTask(String id){
        ResponseMsg res = new ResponseMsg();
        try{
            res.setData(taskJobService.findTask(id));
        }catch (Exception e){
            res.setError(e);
        }
        return res;
    }

    @RequestMapping(value = "/manual")
    @ResponseBody
    public ResponseMsg manual(String id){
        ResponseMsg res = new ResponseMsg();
        try{
            TaskJob task = taskJobService.findTask(id);
            Job job = (Job) Class.forName(task.getJobClass()).newInstance();
            capableBeanFactory.autowireBean(job);
            job.execute(null);
        }catch (Exception e){
            res.setError(e);
        }
        return res;
    }
}
