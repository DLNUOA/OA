package edu.dlnu.oa.emp.service.serviceImpl;

import edu.dlnu.oa.emp.mapper.EmpMapper;
import edu.dlnu.oa.emp.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wuhan
 * @date 2019/12/30 19:49
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;
    @Override
    public List<Map<String, Object>> getEmps() {
        return empMapper.getEmpInfo();
    }

    @Override
    public int postAEmp(Map<String, Object> emp) {
        return empMapper.postAEmp(emp);
    }

    @Override
    public int deleteEmpById(int empId) {
        return empMapper.deleteEmpById(empId);
    }

    @Override
    public int updateEmp(Map<String, Object> info) {
        return empMapper.updateEmp(info);
    }
}
