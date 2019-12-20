package edu.dlnu.oa.dept.controller;

import edu.dlnu.oa.dept.pojo.Dept;
import edu.dlnu.oa.dept.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author wuhan
 * @date 2019/12/20 21:01
 */
@RestController
@RequestMapping("/api")
public class DeptController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DeptService deptService;


    @RequestMapping(value = "/dept",method = GET)
    public List<Dept> getAllDept(){
        log.info("Dept被访问了");
        return deptService.findAllDept();
    }
    @RequestMapping(value = "/dept/{id}",method = DELETE)
    public int deleteDeptById(@PathVariable int id){
        return deptService.deleteDeptById(id);
    }
    @RequestMapping(value = "/dept", method = POST)
    public int postADept(@RequestBody Dept dept ){
        return deptService.insertDept(dept);
    }

}
