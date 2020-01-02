package edu.dlnu.oa.carCenter.controller;

import edu.dlnu.oa.carCenter.pojo.CarCenter;
import edu.dlnu.oa.carCenter.service.CarRentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * 派车相关Controller
 */

@RestController
@RequestMapping("/api")
public class CarRentController {

    //设置日志
    private Logger log = LoggerFactory.getLogger(this.getClass());

    //注入
    @Autowired
    private CarRentService service;

    //查询派车记录
    @RequestMapping(value = "/car/queryCarRent", method = GET)
    public List<Map<String,Object>> query() { return service.queryCarRent(); }

    //查询派车代办列表
    @RequestMapping(value = "/car/queryRentList", method = GET)
    public List<Map<String,Object>> queryRentList() { return service.queryCarRentList(); }

    //查询可派车辆信息
    @RequestMapping(value = "/car/queryPlan", method = GET)
    public  List<Map<String,Object>> queryPlanCar() { return service.queryCarPlan(); }

    //改变车辆派车状态，改变可派车列表里的car_id
    @RequestMapping(value = "/car/updateState", method = PUT)
    public int updateState(@RequestBody Map<String,Integer> map) { return service.updateAndAddRent(map); }

    //根据ID查询车辆信息
    @RequestMapping(value = "/car/queryByPlanId/{carId}", method = GET)
    public CarCenter queryByPlanId(@PathVariable int carId) { return service.queryByPlanIdCar(carId); }

    //获取行政主管信息
    @RequestMapping(value = "/car/getJobList", method = GET)
    public Map<String,Object> getJobList() { return service.queryJobList("行政主管"); }

    //提交用车申请
    @RequestMapping(value = "/emp/carApply", method = POST)
    public int add(@RequestBody Map<String, Object> apply, HttpServletRequest request) {
        String applyId = (String) request.getSession().getAttribute("empId");
        Map<String, Object> map = service.queryJobList("行政主管");
        Map<String, Object> list = new HashMap<>();
        list.put("carRentLine", apply.get("carRentLine"));
        list.put("carRentInfo", apply.get("carRentInfo"));
        list.put("carApplyTime", apply.get("carApplyTime"));
        list.put("carRentStime", apply.get("carRentStime"));
        list.put("carRentOtime", apply.get("carRentOtime"));
        list.put("empApplyId", applyId);
        list.put("empCheckmanId", map.get("emp_id"));
        return service.addApply(list); }
}
