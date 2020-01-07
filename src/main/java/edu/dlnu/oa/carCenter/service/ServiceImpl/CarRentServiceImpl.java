package edu.dlnu.oa.carCenter.service.ServiceImpl;

import edu.dlnu.oa.carCenter.mapper.CarRentMapper;
import edu.dlnu.oa.carCenter.pojo.CarCenter;
import edu.dlnu.oa.carCenter.pojo.CarRent;
import edu.dlnu.oa.carCenter.service.CarRentService;
import edu.dlnu.oa.job.pojo.Job;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 派车Service类，接口实现
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CarRentServiceImpl implements CarRentService {

    @Resource
    private CarRentMapper mapper;

    //查询派车记录
    @Override
    public List<Map<String,Object>> queryCarRent() { return mapper.queryByState(); }

    //查询租车人和审批人姓名
    @Override
    public List<Map<String,Object>> queryCarRentList() {
        List<Map<String,Object>> list1 = mapper.queryPeopleId();
        List<Map<String,Object>> list2 = mapper.queryEmpInfo();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                //else if  判断空的时候可能会有bug  暂时这样 等待优化算法
                if ( list1.get(i).get("emp_apply_id") == list2.get(j).get("emp_id")) {
                    list1.get(i).put("emp_apply_name", list2.get(j).get("emp_name"));
                } else if (list1.get(i).get("emp_apply_id") == null) {
                    list1.get(i).put("emp_apply_name", "");
                }
                if (list1.get(i).get("emp_checkman_id") == list2.get(j).get("emp_id")) {
                    list1.get(i).put("emp_checkman_name", list2.get(j).get("emp_name"));
                } else if (list1.get(i).get("emp_checkman_id") == null) {
                    list1.get(i).put("emp_checkman_name", "");
                }

            }
        }
        return list1;
    }

    //查询自己的用车申请
    @Override
    public  List<Map<String,Object>> queryMyRentList(int empApplyId) {
        List<Map<String,Object>> list1 = mapper.queryEmpInfo();
        List<Map<String,Object>> list2 = mapper.queryMyList(empApplyId);
        for(int i = 0; i< list2.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {
                if(list2.get(i).get("emp_checkman_id") == list1.get(j).get("emp_id")) {
                    list2.get(i).put("emp_checkman_name",list1.get(j).get("emp_name"));
                }

            }
        }
        return list2;
    }

    //查询所有行政审批的用车信息
    @Override
    public  List<Map<String,Object>> queryXingList(int empCheckmanId) {
        List<Map<String,Object>> list2 = mapper.queryXingZheng(6);
        List<Map<String,Object>> list1 = mapper.queryEmpInfo();
        for(int i = 0; i< list2.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {
                if(list2.get(i).get("emp_apply_id") == list1.get(j).get("emp_id")) {
                    list2.get(i).put("emp_apply_name",list1.get(j).get("emp_name"));
                }
                if(list2.get(i).get("emp_checkman_id") == list1.get(j).get("emp_id")) {
                    list2.get(i).put("emp_checkman_name",list1.get(j).get("emp_name"));
                }
            }
        }
        return list2;}

    //查询可派车辆列表
    @Override
    public List<Map<String,Object>> queryCarPlan() {
        return mapper.queryCarState();
    }

    //改变车辆派车状态，改变可派车列表里的car_id
    //派车记录存入记录
    @Override
    public int updateAndAddRent(Map<String,Integer> map) {
         mapper.updateCarState(map.get("carId"));
         mapper.updateRentState(map.get("carId"), map.get("carRentId"));
         Map<String, Object> car = mapper.queryByRentId(map.get("carRentId"));
         Map<String, Object> list = new HashMap<>();
         list.put("rent_emp_id", car.get("emp_apply_id"));
         list.put("rent_car_id", car.get("car_id"));
         list.put("rent_line", car.get("car_rent_line"));
         list.put("rent_stime", car.get("car_rent_stime"));
         list.put("rent_otime", car.get("car_rent_otime"));
         mapper.insertRentList(list);
        System.out.println(list);
       return 1;
    }

    //根据ID查找车辆信息
    @Override
    public CarCenter queryByPlanIdCar(int carId) { return mapper.queryByPlanId(carId); }

    //查询审批人信息
    @Override
    public Map<String,Object> queryJobList(String jobName) {return mapper.queryJob(jobName);}

    //提交申请
    @Override
    public int addApply(Map<String, Object> apply) {return mapper.insertApply(apply);}

    //查询自己所有的车辆申请
    @Override
    public List<Map<String,Object>> querySelf(int empApplyId) { return mapper.queryListSelf(empApplyId);}

    //通过审批
    @Override
    public int updateXZ(int carRentId) { return  mapper.updateRentS(carRentId);}

}
