package edu.dlnu.oa.common.mapper;

import edu.dlnu.oa.emp.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginValidMapper {
    @Select("SELECT * FROM emp WHERE emp_login_name = #{loginName} AND emp_pwd = #{password} ")
    List<Emp> loginValid(Map<String,String> loginInfo);

    @Insert("INSERT INTO emp (emp_id,emp_name,emp_login_name,emp_pwd,emp_dept_id,emp_job_id) VALUES(DEFAULT,#{ln},#{ln},#{pwd},-1,-1)")
    int signUp(@Param("ln") String loginName, @Param("pwd") String password);

}
