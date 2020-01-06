package edu.dlnu.oa.URLController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wuhan
 * @date 2019/12/26 12:40
 */
@Controller
@RequestMapping("/systemManage")
public class SystemManageURLController {
    @RequestMapping("/deptManage")
    public String deptManage(){
        return "systemManage/DeptManage";
    }
<<<<<<< HEAD
=======
    @RequestMapping("/empManage")
    public String empManage(){
        return "systemManage/EmpManage";
    }
    @RequestMapping("/job")
    public String job(){
        return "systemManage/JobManage";
    }
    @RequestMapping("/reply/rm")
    public String rm(){
        return "systemManage/ReplyManage";
    }

    @RequestMapping("/reply/baoxiao")
    public String baoxiao(){
        return "systemManage/BaoxiaoReply";
    }

    @RequestMapping("/reply")
    public String reply(){
        return "systemManage/ReplyCenter";
    }
>>>>>>> 13c562ae6f524e798f73818135bf8ce80b9f2e44
}
