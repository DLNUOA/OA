package edu.dlnu.oa.carCenter.mapper;

import edu.dlnu.oa.carCenter.pojo.CarCenter;
import edu.dlnu.oa.carCenter.pojo.CarRent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.List;
import java.util.Map;

/**
 * 派车记录
 */
@Mapper
public interface CarRentMapper {

    //查询派车记录
    @Select("SELECT r.* ,e.*, c.* FROM rent_list r  INNER JOIN emp e ON r.`rent_emp_id`=e.`emp_id` INNER JOIN car c ON r.`rent_car_id`=c.`car_id`")
    List<Map<String,Object>> queryByState();

    //待派车列表
    @Select("SELECT c.*, e.*, e2.* FROM car_rent c INNER JOIN emp e ON c.`emp_apply_id`=e.`emp_id` LEFT OUTER JOIN emp e2 ON c.`emp_checkman_id`=e2.`emp_id` WHERE car_rent_state=0")
    List<Map<String, Object>> queryCarRentList();

    //查询租车人和审批人的ID
    @Select("SELECT * FROM car_rent WHERE car_rent_state = 0")
    List<Map<String,Object>> queryPeopleId();

    //查询员工的ID和姓名
    @Select("SELECT emp_id, emp_name FROM emp")
    List<Map<String,Object>> queryEmpInfo();

    //查询可派车辆信息
    @Select("SELECT * FROM car WHERE car_state=0")
    List<Map<String,Object>> queryCarState();

    //修改车辆状态为已经派出
    @Update("UPDATE car SET car_state = 1 WHERE car_id = #{carId}")
    int updateCarState(int carId);

    //rent_car的状态改变成已派出，车辆编号存入派车表
    @Update("UPDATE car_rent SET car_id = #{carId}, car_rent_state=2 WHERE car_rent_id = #{carRentId}")
    int updateRentState(int carId, int carRentId);

    //派车记录存入记录
    @Insert("INSERT INTO rent_list VALUES(default, #{rent_emp_id}, #{rent_car_id}, #{rent_line}, #{rent_stime}, #{rent_otime})")
    int insertRentList(Map<String, Object> list);

    //根据id找租车信息
    @Select("SELECT * FROM car_rent WHERE car_rent_id = #{carRentId}")
    Map<String, Object> queryByRentId(int carRentId);

    //根据ID查询车辆信息
    @Select("SELECT car_type, car_pic FROM car WHERE car_id = #{carId}")
    CarCenter queryByPlanId(int carId);
}
