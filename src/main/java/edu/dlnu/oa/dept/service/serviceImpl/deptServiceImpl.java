package edu.dlnu.oa.dept.service.serviceImpl;

import edu.dlnu.oa.dept.pojo.Dept;
import edu.dlnu.oa.dept.service.DeptService;
import edu.dlnu.oa.mapper.DeptMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuhan
 * @date 2019/12/20 20:26
 */
@Service
public class deptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;
    @Override
    public int insertDept(Dept dept) {
        return deptMapper.insertDept(dept);
    }

    @Override
    public List<Dept> findAllDept() {
        return deptMapper.findAllDept();
    }

    @Override
    public int deleteDeptById(int id) {
        return deptMapper.deleteDeptById(id);
    }
}
