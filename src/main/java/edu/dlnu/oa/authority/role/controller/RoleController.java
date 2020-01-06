package edu.dlnu.oa.authority.role.controller;

import edu.dlnu.oa.authority.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wuhan
 * @date 2020/1/2 13:12
 */
@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/roleInfo")
    public List<Map<String,Object>> getRoleInfo(){
        return roleService.getRoleInfo();
    }
}
