package edu.dlnu.oa.dept.mapper;

import edu.dlnu.oa.dept.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeptMapper {
    @Insert("insert into dept values(default, #{deptName},#{deptLoc},#{deptIntro})")
    int insertDept(Dept dept);

    @Select("select * from dept")
    List<Dept> findAllDept();

    @Delete("delete from dept where dept_id = #{id} ")
    int deleteDeptById(int id);

    @Update("UPDATE dept SET dept.dept_name= #{deptName},dept.dept_loc=#{deptLoc} ,dept.dept_intro=#{deptIntro} \n" +
            "WHERE dept.dept_id = #{deptId}")
    int updateDept(Dept dept);

    @Select("SELECT dept_id ,dept_name FROM dept where dept_id>0")
    List<Map<String,Object>> getDeptIdAndDeptName();

}
