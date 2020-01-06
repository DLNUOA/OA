package edu.dlnu.oa.asset.service;

import edu.dlnu.oa.emp.pojo.Emp;

import java.util.List;
import java.util.Map;

public interface ZHEmpService {

    List<Map<String,Object>> queryEmp();
    Emp queryEmpById(Integer empId);

}
