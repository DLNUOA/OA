package edu.dlnu.oa.peopleSend.mapper;


import edu.dlnu.oa.peopleSend.pojo.ComSendPeople;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 外派人员操作
 */
@Mapper
public interface PeopleSendMapper {

    //查找所有外派人员列表
    @Select("SELECT * FROM com_send_people")
    List<ComSendPeople> query();

    //添加外派人员信息
    @Insert("INSERT INTO com_send_people VALUES(default, #{spName},#{spEdu},#{spWork}, #{spAbility}, #{spLoc}, #{spSalay}, #{spState})")
    int insert(ComSendPeople csp);

    //删除外派人员信息
    @Delete("DELETE FROM com_send_people sp_id = #{spId}")
    int delete(int spId);

    //修改外派人员信息
    @Update("UPDATE com_send_people SET sp_name=#{spName}, sp_edu=#{spEdu}, sp_work=#{spWork}, sp_ability=#{spAbility}, sp_loc=#{spLoc}," +
            "sp_salay=#{apSalay}, sp_state=#{spState}")
    int update(ComSendPeople csp);

    //根据ID搜索员工信息
    @Select("SELECT * FROM com_send_people WHERE sp_id=#{spId}")
    ComSendPeople queryById(int spId);

    //根据姓名搜素人员信息
    @Select("SELECT * FROM com_send_people WHERE sp_name=#{spName}")
    ComSendPeople queryByName(String spName);

}
