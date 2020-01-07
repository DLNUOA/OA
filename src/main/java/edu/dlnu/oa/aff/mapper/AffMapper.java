package edu.dlnu.oa.aff.mapper;


import edu.dlnu.oa.aff.pojo.Aff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AffMapper {
    @Insert("insert into aff values(default, #{affName},#{affCont},#{affData},#{affEmpId})")
    int insertAff(Aff aff);

    @Select("select * from aff")
    List<Aff> queryAff();

    @Delete("delete from aff where aff_id = #{affId} ")
    int deleteAffById(int affId);

    @Update("UPDATE aff SET Aff.aff_name= #{affName}, Aff.aff_cont=#{affCont}\n" +
            "WHERE  Aff.aff_id = #{affId}")
    int updateAff(Aff aff);

    @Select("select * from aff where aff_id = #{affId}")
    List<Aff> queryAffById(int aff);

}
