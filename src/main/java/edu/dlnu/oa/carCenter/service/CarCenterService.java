package edu.dlnu.oa.carCenter.service;

import edu.dlnu.oa.carCenter.pojo.CarCenter;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 */
@Primary
public interface CarCenterService {

    //添加车辆信息
    int addCar(Map<String,Object> car);

    //查询全部车辆信息
    List<CarCenter> queryCar();

    //根据ID查询车辆信息
    CarCenter queryByIdCar(int carId);

    //删除车辆信息
    int deleteCar(int carId);

    //更改车辆信息
    int updateCar(Map<String,Object> car);
}
