package edu.dlnu.oa.carCenter.service.ServiceImpl;

import edu.dlnu.oa.carCenter.mapper.CarCenterMapper;
import edu.dlnu.oa.carCenter.pojo.CarCenter;
import edu.dlnu.oa.carCenter.service.CarCenterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Service类，接口实现
 */
@Service
public class CarCenterServiceImpl implements CarCenterService {

    @Resource
    private CarCenterMapper mapper;

    //插入车辆信息
    @Override
    public int addCar(Map<String,Object> car) { return  mapper.insert(car);}

    //查找所有车辆信息
    @Override
    public List<CarCenter> queryCar() { return mapper.query(); }


    //根据ID查找车辆信息
    @Override
    public CarCenter queryByIdCar(int carId) { return mapper.queryById(carId); }

    //删除车辆信息
    @Override
    public int deleteCar(int carId) { return mapper.delete(carId); }

    //更改车辆信息
    @Override
    public int updateCar(Map<String,Object> car) { return mapper.update(car); }
}
