package demo.job;

import demo.po.TaskJob;
import demo.service.TaskJobService;
import demo.service.impl.QuartzManager;
import demo.util.YmlUtil;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author wangmt
 * @date 2017/11/14
 */
public class JobManager implements InitializingBean {
    @Autowired
    private TaskJobService taskJobService;
    @Autowired
    private QuartzManager quartzManager;

    @Override
    public void afterPropertiesSet() throws Exception {
        loadAllYmal();
        loadAllJob();
    }

    private void loadAllYmal() throws IOException {
        ClassPathResource path = new ClassPathResource("yml");
        File[] files = path.getFile().listFiles();
        for (File file: files) {
            if(file.getName().indexOf("yml")>0){
                Object o = YmlUtil.readYml(file);
                YmlUtil.addCache(file.getName().replace(".yml",""),o);
            }
        }
    }

    private void loadAllJob() throws SchedulerException {
        List<TaskJob> list =taskJobService.getTaskList();
        quartzManager.enableCronSchedule(list);
    }
}
