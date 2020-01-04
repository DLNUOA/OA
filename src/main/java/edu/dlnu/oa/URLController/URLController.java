package edu.dlnu.oa.URLController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class URLController {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/index")
    public String index(){
        log.info("Visit CloudOa Index");
        return "cloudOa/index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping({"/newIndex","/"})
    public String newLogin(){
        return "newIndex";
    }



    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/contactUs")
    public String contactUs(){
        return "contactUs";
    }

    @RequestMapping("/fy")
    public String fy(){
        return "fy";
    }
    @RequestMapping("/signUp")
    public String signUp(){
        return "signUp";
    }

    @RequestMapping("/nav")
    public String nav(){
        return "nav";
    }
    @RequestMapping("/n")
    public String n(){
        return "navsidebar";
    }

    @RequestMapping("/index/pageNotFound")
    public String notfound(){
        return "404";
    }



}
