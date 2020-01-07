package edu.dlnu.oa.peopleSend.mapper;

import edu.dlnu.oa.peopleSend.pojo.ComSendList;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 外派记录
 */
@Mapper
public interface ComSendListMapper {

    //查询所有外派记录
    @Select("SELECT * FROM com_send_list")
    List<Map<String,Object>> query();

    //添加外派记录
    @Insert("INSERT INTO com_send_list VALUES(default, #{sendSpId}, #{sendComId}, #{sendPeopleName}, #{sendComName})")
    int insert(Map<String,Object> csl);

    //删除外派记录
    @Delete("DELETE FROM com_send_list WHERE send_id=#{sendId}")
    int delete(int sendId);

    //根据id修改外派人员状态
    @Update("UPDATE com_send_people SET sp_state=#{spState} WHERE sp_id=#{spId}")
    int update(int spId,int spState);
}
