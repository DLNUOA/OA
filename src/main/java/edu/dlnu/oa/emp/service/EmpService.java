package edu.dlnu.oa.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
    List<Map<String, Object>> getEmps();

    int postAEmp(Map<String, Object> emp);

    int deleteEmpById(int empId);

    int updateEmp(Map<String, Object> info);
}
