package edu.dlnu.oa.carCenter.service;

import edu.dlnu.oa.carCenter.pojo.CarCenter;
import edu.dlnu.oa.carCenter.pojo.CarRent;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Map;

/**
 * 派车Srvice接口
 */
@Primary
public interface CarRentService {

    //查询全部派车信息
    List<Map<String,Object>> queryCarRent();

    //查询派车代办列表
    List<Map<String,Object>> queryCarRentList();

    //查询可派车辆列表
    List<Map<String,Object>> queryCarPlan();

    //改变车辆派车状态，改变可派车列表里的car_id
    //派车记录存入记录
   int updateAndAddRent(Map<String,Integer> map);

    //根据ID查询车辆信息
    CarCenter queryByPlanIdCar(int carId);
}
