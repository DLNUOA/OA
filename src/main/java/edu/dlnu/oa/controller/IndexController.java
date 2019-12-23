package edu.dlnu.oa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/")
    public String index(){
        log.info("Visit Index");
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/dataTable")
    public String dataTable(){
        return "datatableExample";
    }
}
