package edu.dlnu.oa.URLController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 外派管理Url配置
 */
@Controller
@RequestMapping("/Send")
public class SendPersonUrlController {

    //外派人员信息页面
    @RequestMapping("/SendPerson")
    public String peopleSendList() { return "sendPerson/peopleSendList";}
}
