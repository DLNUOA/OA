package edu.dlnu.oa.personCenter.service.serviceImpl;

import edu.dlnu.oa.personCenter.mapper.PersonCenterMapper;
import edu.dlnu.oa.personCenter.service.PersonCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wuhan
 * @date 2019/12/23 23:25
 */
@Service
public class PersonCenterServiceImpl implements PersonCenterService {
    @Resource
    private PersonCenterMapper personCenterMapper;
    @Override
    public List<Map<String, Object>> getPersonInfoById(int empId) {
        return personCenterMapper.getEmpInfoById(empId);
    }
}
