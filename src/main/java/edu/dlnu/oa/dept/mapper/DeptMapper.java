package edu.dlnu.oa.dept.mapper;

import edu.dlnu.oa.dept.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Insert("insert into dept values(default, #{dept.name},#{dept.address})")
    int insertDept(@Param("dept")Dept dept);

    @Select("select * from dept")
    List<Dept> findAllDept();

    @Update("update dept set deleted = 1  where id = #{id}")
    int deleteDeptById(int id);

}
