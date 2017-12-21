package demo.view;

import demo.service.ErrorCentreService;
import demo.service.TaskJobService;
import demo.vo.ResponseMsg;
import demo.vo.TaskJobVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangmt
 * @date 2017/12/1
 */
@Controller
@RequestMapping("errorCentre")
public class ErrorCentreView {


    @Autowired
    private ErrorCentreService errorCentreService;

    @RequestMapping(value = "list")
    @ResponseBody
    public ResponseMsg getTaskList(TaskJobVo vo){
        ResponseMsg res = new ResponseMsg();
        try{
            res.setData(errorCentreService.findList(vo));
        }catch (Exception e){
            res.setError(e);
        }
        return res;
    }


}
