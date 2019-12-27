package edu.dlnu.oa.common.mapper;

import edu.dlnu.oa.emp.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginValidMapper {
    @Select("SELECT * FROM emp WHERE emp_login_name = #{loginName} AND emp_pwd = #{password} ")
    List<Emp> loginValid(Map<String,String> loginInfo);
}
