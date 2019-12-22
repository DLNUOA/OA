package edu.dlnu.oa.common.controller;

import edu.dlnu.oa.common.service.LoginValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wuhan
 * @date 2019/12/22 23:10
 */
@RestController
public class LoginController {
    @Autowired
    private LoginValidService loginValidService;
    @RequestMapping(value = "/userLogin",method = POST)
    public int LoginValid(@RequestBody Map<String,String> loginInfo, HttpServletRequest request){
        return loginValidService.loginValid(loginInfo);
    }
}
