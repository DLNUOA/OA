package edu.dlnu.oa.asset.mapper;

import edu.dlnu.oa.emp.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ZHEmpMapper {
    @Select(" SELECT  e.emp_id,e.emp_name,d.dept_name FROM dept d INNER JOIN emp e ON d.`dept_id`=e.`emp_dept_id`")
//    @Select("SELECT emp_Id emp_Name, dept_Name FROM emp INNER JOIN dept ON emp_dept_id = dept_id")
    List<Map<String,Object>> query();

    @Select("select * from emp where emp_id=#{empId}")
    Emp queryById(Integer empId);

}
