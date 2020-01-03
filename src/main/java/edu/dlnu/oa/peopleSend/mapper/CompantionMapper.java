package edu.dlnu.oa.peopleSend.mapper;

import edu.dlnu.oa.peopleSend.pojo.Compantion;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 外派公司相关操作
 */
@Mapper
public interface CompantionMapper {

    //查询所有合作公司信息
    @Select("SELECT * FROM compantion")
    List<Compantion> query();

    //修改合作公司信息
    @Update("UPDATE compantion SET com_name=#{comName}, com_linkman_name=#{comLinkmanName}," +
            "com_linkman_phone=#{comLinkmanPhone}, com_linkman_qq=#{comLinkmanQq}," +
            "com_info=#{comInfo} WHERE com_id=#{comId}")
    int update(Compantion com);

    //根据id查找合作信息
    @Select("SELECT * FROM compantion WHERE com_id=#{comId}")
    Compantion queryById(int comId);

    //添加新的合作公司
    @Insert("INSERT INTO compantion VALUES(default, #{comName}, #{comLinkmanName}, #{comLinkmanPhone}, " +
            "#{comLinkmanQq}, #{comInfo})")
    int add(Compantion com);

    //删除合作公司
    @Delete("DELETE FROM compantion WHERE com_id=#{comId}")
    int delete(int comId);

    //查看所有公司需求
    @Select("SELECT * FROM com_demand d LEFT JOIN compantion c ON d.`dem_com_id`=c.`com_id`")
    List<Map<String, Object>> queryDemand();

    //添加新的需求
    @Insert("INSERT INTO com_demand VALUES(default, #{demJob}, #{demJobType}, #{demSalay}, #{demComId})")
    int addDemand(Map<String ,Object> dem);

    //修改公司需求
    @Update("UPDATE com_demand SET dem_job=#{demJob}, dem_job_type=#{demJobType}, dem_salay=#{demSalay} WHERE dem_id=#{demId}")
    int updateDemand(Map<String,Object> dem);

    //根据Id查找需求
    @Select("SELECT * FROM com_demand d LEFT JOIN compantion c ON d.`dem_com_id`=c.`com_id` WHERE dem_id=#{demId}")
    Map<String ,Object> queryDemById(int demId);

    //删除公司需求
    @Delete("DELETE FROM com_demand WHERE dem_id=#{demId}")
    int deleteDem(int demId);

}
