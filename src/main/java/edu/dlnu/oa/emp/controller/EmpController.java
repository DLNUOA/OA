package edu.dlnu.oa.emp.controller;

import edu.dlnu.oa.emp.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author wuhan
 * @date 2019/12/30 19:46
 */
@RestController
@RequestMapping("/api")
public class EmpController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EmpService empService;
    @GetMapping("/emps")
    public List<Map<String,Object>> getEmps(HttpServletRequest request){
        return empService.getEmps();
    }
    @PostMapping("/emp")
    public int postAEmp(@RequestBody Map<String,Object> emp,HttpServletRequest request){
        return empService.postAEmp(emp);
    }

}
