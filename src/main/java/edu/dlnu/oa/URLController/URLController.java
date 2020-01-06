package edu.dlnu.oa.URLController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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


//zhanghan
    @RequestMapping("/AddAsset")
    public String AddAsset(){
            return "asset/AddAsset";
    }
    @RequestMapping("/AddConsume")
    public String AddConsume(){
        return "asset/AddConsume";
    }
//    @RequestMapping("/AddAsset")
//    public String AddAsset(){
//        return "asset/AddAsset22";
//    }


    @RequestMapping("/fy")
    public String fy(){
        return "fy";
    }

    @RequestMapping("/Select1")
    public String Select1(){
        return "asset/Select1";
    }

    @RequestMapping("/Select2")
    public String Select2(){
        return "asset/Select2";
    }


    @RequestMapping("/Main")
    public String Main(){
        return "asset/Main";
    }


    @RequestMapping("/index2")
    public String index2(){
        return "asset/index";
    }

    @RequestMapping("/nav")
    public String nav(){
        return "asset/nav";
    }



}
