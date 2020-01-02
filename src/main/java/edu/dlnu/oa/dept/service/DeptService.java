package edu.dlnu.oa.dept.service;

import edu.dlnu.oa.dept.pojo.Dept;

import java.util.List;
import java.util.Map;

public interface DeptService {
     int insertDept(Dept dept);
     List<Dept> findAllDept();
     int deleteDeptById(int id);
     int updateDept(Dept dept);
     List<Map<String,Object>> getDeptIdAndName();

}
