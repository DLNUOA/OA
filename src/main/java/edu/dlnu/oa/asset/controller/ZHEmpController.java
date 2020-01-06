package edu.dlnu.oa.asset.controller;

import edu.dlnu.oa.asset.service.ZHEmpService;
import edu.dlnu.oa.emp.pojo.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
@RestController
@RequestMapping("/api")
public class ZHEmpController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ZHEmpService service;

    @RequestMapping(value = "/emp/query", method=POST)
    public List<Map<String,Object>> query(){
        List<Map<String,Object>> list=service.queryEmp();
        return list;

    }

    @RequestMapping(value = "/emp/queryById/{empId}", method=POST)
    public Emp queryById(@PathVariable Integer empId) {
        return  service.queryEmpById(empId);
    }

}
