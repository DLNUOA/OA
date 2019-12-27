package edu.dlnu.oa.carCenter.mapper;

import edu.dlnu.oa.carCenter.pojo.CarCenter;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 车辆管理Mapper
 */
@Mapper
public interface CarCenterMapper {

    //添加车辆信息
    @Insert("INSERT INTO car VALUES(default, #{car.carType}, #{car.carNum}, #{car.carPic})")
    int insert(@Param("car") CarCenter car);

    //查询所有车辆信息
    @Select("SELECT * FROM car ")
    List<CarCenter> query();

    //根据ID查询车辆信息
    @Select("SELECT car_type, car_pic FROM car WHERE car_id = #{carId}")
    CarCenter queryById(int carId);

    //删除车辆信息
    @Delete("DELETE FROM car WHERE car_id = #{carId}")
    int delete(int carId);

    //更新车辆信息
    @Update("UPDATE car SET car_type = #{carType}, car_num = #{carNum}, car_pic = #{carPic} WHERE car_id = #{carId}")
    int update(CarCenter car);
}
