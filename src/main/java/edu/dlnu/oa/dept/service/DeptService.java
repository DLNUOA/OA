package edu.dlnu.oa.dept.service;

import edu.dlnu.oa.dept.pojo.Dept;

import java.util.List;

public interface DeptService {
     int insertDept(Dept dept);
     List<Dept> findAllDept();
     int deleteDeptById(int id);

}