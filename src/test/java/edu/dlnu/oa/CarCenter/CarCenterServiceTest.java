package edu.dlnu.oa.CarCenter;

import edu.dlnu.oa.carCenter.pojo.CarCenter;
import edu.dlnu.oa.carCenter.service.CarCenterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 车辆管理的Service测试
 */

@SpringBootTest
public class CarCenterServiceTest {
    @Autowired
    private CarCenterService service;

    //测试添加车辆信息的Service
    @Test
    public void testInsert() {
        CarCenter car = new CarCenter("宝马bb", "辽A-B1234", "");
        service.addCar(car);
    }

    //测试查询全部车辆信息的Service
    @Test
    public void testQuery() {
        List<CarCenter> list = service.queryCar();
        for(CarCenter car : list) {
            System.out.printf(car.toString());
        }
    }

    //测试根据ID查询车辆信息的Service
    @Test
    public void testQueryById() {
        CarCenter car = service.queryByIdCar(6);
        System.out.println(car);
    }

    //测试删除车辆信息的Service
    @Test
    public void testDelete() {
        service.deleteCar(10);
    }

    //测试修改车辆信息的Service
    @Test
    public void testUpdate() {
        CarCenter car = new CarCenter(9,"五菱面包车", "辽A-B1234","");
        service.updateCar(car);
    }
}
