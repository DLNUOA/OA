package edu.dlnu.oa.asset.service.serviceImpl;

import edu.dlnu.oa.asset.mapper.ZHEmpMapper;
import edu.dlnu.oa.asset.service.ZHEmpService;
import edu.dlnu.oa.emp.pojo.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class ZHEmpServiceImpl implements ZHEmpService {

    @Resource
    private ZHEmpMapper mapper;

    @Override
    public Emp queryEmpById(Integer empId)
    {
        return  mapper.queryById(empId);

    }

    @Override
    public List<Map<String,Object>> queryEmp()
    {
        return  mapper.query();
    }
}
