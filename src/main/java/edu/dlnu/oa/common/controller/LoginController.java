package edu.dlnu.oa.common.controller;

import edu.dlnu.oa.common.service.LoginValidService;
import edu.dlnu.oa.emp.pojo.Emp;
import edu.dlnu.oa.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wuhan
 * @date 2019/12/22 23:10
 */
@RestController
public class LoginController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LoginValidService loginValidService;
    @RequestMapping(value = "/userLogin",method = POST)
    public Map<String,Object> LoginValid(@RequestBody Map<String,String> loginInfo, HttpServletRequest request,HttpServletResponse response){
        List<Emp> emps = loginValidService.loginValid(loginInfo);
        Map<String,Object> info = new HashMap<>();
        if (emps.size()==1){
            HttpSession session = request.getSession();
            Emp emp = emps.get(0);
            session.setAttribute("empId",emp.getEmpId());
            session.setAttribute("empName",emp.getEmpName());
            session.setAttribute("empRoleId",emp.getEmpRoleId());
            String token = JwtUtils.generateToken(emp.getEmpName(), emp.getEmpId(), emp.getEmpRoleId());
            info.put("result","1");
            info.put("token",token);
        }else {
            info.put("result","0");
        }
        return info;
    }
    @GetMapping("/sessionInfo")
    public Map<String,Object> getSessionInfo(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> sessionInfo = new HashMap<>();
        String token = request.getHeader("Authorization");
//        JwtUtils.validateToken(token);
//        log.info(token);
        Object empName = request.getSession().getAttribute("empName");
        if (empName==null){
            sessionInfo.put("empName",null);
            sessionInfo.put("empId",null);
            sessionInfo.put("empRoleId",null);

        }else {
            sessionInfo.put("empId",request.getSession().getAttribute("empId"));
            sessionInfo.put("empName",request.getSession().getAttribute("empName"));
            sessionInfo.put("empRoleId",request.getSession().getAttribute("empRoleId"));
        }
        return sessionInfo;
    }
    @GetMapping("/loginOut")
    public void loginOut(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Object empName = request.getSession().getAttribute("empName");
        if (empName != null) {
            session.setAttribute("empId", null);
            session.setAttribute("empRoleId", null);
            session.setAttribute("empName", null);
        }
        response.sendRedirect("/");
    }
    @PostMapping("/userSignUp")
    public int loginOut(@RequestBody Map<String,String> signUpInfo,HttpServletRequest request){
        String loginName = signUpInfo.get("loginName");
        String password = signUpInfo.get("password");
        String code = signUpInfo.get("code");
        String verifyCode = request.getSession().getAttribute("verifyCode").toString();
        if (code.equals(verifyCode)){
            return loginValidService.userSignUp(loginName,password);

        }else {
            return -1;
        }
    }


}
