package edu.dlnu.oa.URLController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wuhan
 * @date 2019/12/25 10:12
 */
@Controller
@RequestMapping("/personCenter")
public class PersonCenterUrlController {
    @RequestMapping("/EmpInfoMaintain")
    public String personCenterEmpInfoMaintain(){
        return "cloudOa/personCenterEmpInfoMaintain";
    }
    @RequestMapping("/myInfo")
    public String myInfo(){
        return "personCenter/PersonCenter";
    }

}
