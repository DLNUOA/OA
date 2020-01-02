package edu.dlnu.oa.carCenter.controller;

import edu.dlnu.oa.carCenter.pojo.CarCenter;
import edu.dlnu.oa.carCenter.service.CarCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 *车辆管理中心控制器
 */
@RestController
@RequestMapping("/api")
public class CarCenterController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CarCenterService service;

    //添加车辆信息
    @RequestMapping(value = "/car/add", method = POST)
    public int add(@RequestBody Map<String,Object> car) {

        return service.addCar(car);
    }

    //查询所有车辆信息
    @RequestMapping(value = "/car/query", method = GET)
    public List<CarCenter> query() { return service.queryCar(); }


    //根据ID查询车辆信息
    @RequestMapping(value = "/car/queryById/{carId}", method = GET)
    public CarCenter queryById(@PathVariable int carId) { return service.queryByIdCar(carId); }

    //删除车辆信息
    @RequestMapping(value = "/car/delete/{carId}", method = DELETE)
    public int delete(@PathVariable int carId) { return service.deleteCar(carId); }

    //更改学生信息
    @RequestMapping(value = "/car/update", method = PUT)
    public int update(@RequestBody Map<String,Object> car) { return service.updateCar(car); }
}
