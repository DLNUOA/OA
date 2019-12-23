package edu.dlnu.oa.URLController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class URLController {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("index")
    public String index(){
        log.info("Visit Index");
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping({"/newIndex","/"})
    public String newLogin(){
        return "newIndex";
    }

    @RequestMapping("/AddDept")
    public String AddDept(){
        return "dept/AddDept";
    }

    @RequestMapping("/newAddDept")
    public String newAddDept(){
        return "dept/newAddDept";
    }
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}