package demo.service.impl;

import demo.dao.vipmro.SysJobLogDao;
import demo.dao.vipmro.TaskJobDao;
import demo.po.SysJobLog;
import demo.po.TaskJob;
import demo.service.TaskJobService;
import demo.vo.SchedulingJob;
import demo.vo.TaskJobVo;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author wangmt
 * @date 2017/11/14
 */
@Service
public class TaskJobServiceImpl implements TaskJobService{

    @Autowired
    private TaskJobDao taskJobDao;
    @Autowired
    private QuartzManager quartzManager;
    @Autowired
    private SysJobLogDao sysJobLogDao;




    @Override
    public List<TaskJob> getTaskList() {
        List<TaskJob> list = taskJobDao.findEnableTask();
        if(list == null){
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    public Map<String, Object> findTaskList(TaskJobVo vo) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows",taskJobDao.findTaskList(vo));
        map.put("total",taskJobDao.findTaskListCount(vo));
        return map;
    }

    @Override
    public void openTask(String id) {
        TaskJob task = taskJobDao.findTaskById(id);
        boolean res = false;
        if(task != null){
            try{
            SchedulingJob job = new SchedulingJob();
            job.setJobId(String.valueOf(task.getId()));
            job.setJobName(task.getJobClass());
            //job.setMemos(task.getNote());
            job.setCronExpression(task.getJobCronExpression());
                String  className=  task.getJobClass().trim();
                Class clazz = Class.forName(className);
                job.setStateFulljobExecuteClass(clazz);
                taskJobDao.updateTaskStatus(id,1);
                res = quartzManager.enableCronSchedule(job,null,true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(!res){
            throw new RuntimeException("任务开启失败");
        }
    }

    @Override
    public void stopTask(String id) {
        boolean res = quartzManager.disableSchedule(id);
        if(!res){
            throw new RuntimeException("任务停止失败");
        }else{
            taskJobDao.updateTaskStatus(id,0);
        }
    }

    @Override
    public void saveTask(TaskJobVo vo) {

        try {
            Object clazz = Class.forName(vo.getJobClass()).newInstance();
            if(!(clazz instanceof Job)){
                throw new RuntimeException("不是定时任务class");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("class不存在");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        if(StringUtils.isNotBlank(vo.getId())){
            TaskJob task = taskJobDao.findTaskById(vo.getId());
            if(task.getStatus()==1){
                throw new RuntimeException("请先关闭定时脚本,再进行修改");
            }
            taskJobDao.updateTask(vo);
        }else{
            taskJobDao.saveTask(vo);
        }
    }

    @Override
    public void delTask(String id) {
        TaskJob task = taskJobDao.findTaskById(id);
        if(task.getStatus()==1){
            throw new RuntimeException("请先关闭定时脚本,再进行修改");
        }
        taskJobDao.updateTaskStatus(id,2);
    }

    @Override
    public TaskJob findTask(String id) {
        return taskJobDao.findTaskById(id);
    }

    @Override
    public void stopTaskByClass(String clazz) {
        List<TaskJob> jobs =  taskJobDao.findTaskByClass(clazz);
        for (TaskJob job: jobs) {
            boolean res = quartzManager.disableSchedule(String.valueOf(job.getId()));
            if(!res){
                throw new RuntimeException("任务停止失败");
            }else{
                taskJobDao.updateTaskStatus(String.valueOf(job.getId()),0);
            }
        }
    }

    @Override
    public void saveJobLog(SysJobLog log) {
        sysJobLogDao.save(log);
    }

    @Override
    public void updateJobLog(SysJobLog log) {
        if(log.getId()!=null){
            sysJobLogDao.update(log);
        }
    }
}
