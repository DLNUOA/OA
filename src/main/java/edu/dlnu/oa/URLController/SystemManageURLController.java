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
    @RequestMapping("/empManage")
    public String empManage(){
        return "systemManage/EmpManage";
    }
}
