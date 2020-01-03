package edu.dlnu.oa.peopleSend.mapper;

import edu.dlnu.oa.peopleSend.pojo.ComSendList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 外派记录
 */
@Mapper
public interface ComSendListMapper {

    //查询所有外派记录
    @Select("SELECT * FROM com_send_list")
    List<ComSendList> query();

    //添加外派记录
    @Insert("INSERT INTO com_send_list VALUES(default, #{sendSpId}, #{sendComId}, #{sendPeopleName}, #{sendComName})")
    int insert(ComSendList csl);

    //删除外派记录
    @Delete("DELETE FROM com_send_list WHERE send_id=#{sendId}")
    int delete(int sendId);
}
