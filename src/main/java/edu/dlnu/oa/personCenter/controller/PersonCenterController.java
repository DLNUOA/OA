package edu.dlnu.oa.personCenter.controller;

import edu.dlnu.oa.dept.pojo.Dept;
import edu.dlnu.oa.dept.service.DeptService;
import edu.dlnu.oa.personCenter.service.PersonCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    public List<Map<String,Object>> getPersonInfo(@PathVariable int id){
        log.info("getPersonInfo被访问了");
        return personCenterService.getPersonInfoById(id);
    }
}
