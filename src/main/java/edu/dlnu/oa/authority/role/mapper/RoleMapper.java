package edu.dlnu.oa.authority.role.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {
    @Select("SELECT role_id roleId,role_name roleName FROM role")
    List<Map<String, Object>> getRoleInfo();
}
