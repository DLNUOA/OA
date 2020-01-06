package edu.dlnu.oa.authority.role.service.serviceImpl;

import edu.dlnu.oa.authority.role.mapper.RoleMapper;
import edu.dlnu.oa.authority.role.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wuhan
 * @date 2020/1/2 13:15
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper mapper;
    @Override
    public List<Map<String, Object>> getRoleInfo() {
        return mapper.getRoleInfo();
    }
}
