package edu.dlnu.oa.CarCenter;

import edu.dlnu.oa.carCenter.mapper.CarRentMapper;
import edu.dlnu.oa.carCenter.pojo.CarRent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class CarRentMapperTest {
    @Resource
    private CarRentMapper mapper;

    @Test
    public void testQuery() {
        List<Map<String,Object>> list = mapper.queryByState();
        for (Map car : list) {
            System.out.println(car);
        }
    }

    //修改车辆状态为已经派出，车辆编号存入派车表
//    @Test
//    public void testUpdateCarState() {
//        mapper.updateCarState(6);
//    }

}
