package edu.dlnu.oa.carCenter.service;

import edu.dlnu.oa.carCenter.pojo.CarCenter;
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

    //查询审批人信息
    Map<String,Object> queryJobList(String jobName);

    //提交申请
    int addApply(Map<String, Object> apply);

    //查询自己所有的车辆申请
    List<Map<String ,Object>> querySelf(int empApplyId);

    //查询自己的用车申请
    List<Map<String,Object>> queryMyRentList(int empApplyId);

    //行政主管查看自己要审批的用车信息
    List<Map<String,Object>> queryXingList(int empCheckmanId);

    //通过审批
    int updateXZ(int carRentId);
}
