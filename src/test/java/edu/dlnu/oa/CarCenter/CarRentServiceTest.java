package edu.dlnu.oa.CarCenter;

import edu.dlnu.oa.carCenter.pojo.CarRent;
import edu.dlnu.oa.carCenter.service.CarRentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *派车记录的service测试
 */
@SpringBootTest
public class CarRentServiceTest {
    @Resource
    private CarRentService service;

    //测试查询全部派车记录service
    @Test
    public void testQueryCarRent() {
        List<Map<String,Object>> list = service.queryCarRent();
        for (Map car : list) {
            System.out.println(car);
        }
    }

    //测试输出租车和审批人的id
    @Test
    public void testQueryId() {
        List<Map<String,Object>> list = service.queryCarRentList();
        for(Map map : list) {
            System.out.println(map);
        }
    }

    //改变车辆派车状态，改变可派车列表里的car_id
    //派车记录存入记录
    @Test
    public void testUpdateAndAddRent() {
        Map<String,Integer> map = new HashMap<>();
        map.put("carId",7);
        map.put("carRentId",4);
        service.updateAndAddRent(map);
    }

}
