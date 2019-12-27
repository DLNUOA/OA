package edu.dlnu.oa.common.controller;

import edu.dlnu.oa.common.service.LoginValidService;
import edu.dlnu.oa.emp.pojo.Emp;
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
    @Autowired
    private LoginValidService loginValidService;
    @RequestMapping(value = "/userLogin",method = POST)
    public int LoginValid(@RequestBody Map<String,String> loginInfo, HttpServletRequest request){
        List<Emp> emps = loginValidService.loginValid(loginInfo);
        if (emps.size()==1){
            HttpSession session = request.getSession();
            Emp emp = emps.get(0);
            session.setAttribute("empId",emp.getEmpId());
            session.setAttribute("empName",emp.getEmpName());
            session.setAttribute("empRoleId",emp.getEmpRoleId());
            return 1;
        }else {
            return 0;
        }
    }
    @GetMapping("/sessionInfo")
    public Map<String,Object> getSessionInfo(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> sessionInfo = new HashMap<>();
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
}
