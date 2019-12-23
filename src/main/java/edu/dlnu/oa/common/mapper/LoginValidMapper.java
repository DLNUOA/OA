package edu.dlnu.oa.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface LoginValidMapper {
    @Select("SELECT COUNT(*) FROM emp WHERE login_name = #{loginName} AND PASSWORD = #{password} ")
    int loginValid(Map<String,String> loginInfo);
}
