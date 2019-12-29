package edu.dlnu.oa.personCenter.controller;

import edu.dlnu.oa.personCenter.dto.SaveUpdateDto;
import edu.dlnu.oa.personCenter.service.PersonCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author wuhan
 * @date 2019/12/23 22:35
 */
@RestController
@RequestMapping("/api/personCenter")
public class PersonCenterController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PersonCenterService personCenterService;
    @RequestMapping(value = "/personInfo/{id}",method = GET)
    public Map<String,Object> getPersonInfo(@PathVariable int id){
        log.info("getPersonInfo被访问了");
        return personCenterService.getPersonInfoById(id);
    }


    @RequestMapping(value = "/personInfo",method = GET)
    public Map<String,Object> getPersonInfoDefault(HttpServletRequest request, HttpServletResponse response){
        log.info("getPersonInfoDefault被访问了");

        /**
         * 下面这一行代码是错误示范，别写可读性这么差的，然后粒度那么大
         * return personCenterService.getPersonInfoById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("empId"))));
         */
//        我要开始写正确的代码了！@！这里涉及登陆权限，只只有登陆的用户才能访问这个api，上面写的没毛病，但是我们还是要进行出错处理
        Object empId =  request.getSession().getAttribute("empId");
        if (empId==null){
            Map<String,Object> errorMsg= new HashMap<>();
            errorMsg.put("errorMsg","未登录");
            return errorMsg;
        }else {
            return personCenterService.getPersonInfoById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("empId"))));

        }

    }

    @PutMapping("/updateMyInfo")
    public int updateMyInfo(HttpServletRequest request, @RequestBody SaveUpdateDto saveUpdateDto){
        //像下面这样写一定要保证用户已经登陆了！！！！！！！！！！请权限管理同学做好准备
        int empId =  Integer.parseInt( request.getSession().getAttribute("empId").toString());
        saveUpdateDto.setEmpId(empId);
        return personCenterService.updatePersonInfo(saveUpdateDto);
    }

    @PostMapping("/sendValidEmail")
    public int sendValidEmail(HttpServletRequest request){
        int empId =  Integer.parseInt( request.getSession().getAttribute("empId").toString());
        Map<String, Object> personInfo = personCenterService.getPersonInfoById(empId);
        String email =  personInfo.get("email").toString();
        int code = personCenterService.sendValidEmail(email);
        request.getSession().setAttribute("code",code);
        return 1;
    }

    @PostMapping("/updatePwd")
    public int updatePwd(@RequestBody Map<String,Object> updatePwdInfo,HttpServletRequest request){

        return 1;
    }


}
