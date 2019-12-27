package edu.dlnu.oa.common.service.serviceImpl;

import edu.dlnu.oa.common.mapper.LoginValidMapper;
import edu.dlnu.oa.common.service.LoginValidService;
import edu.dlnu.oa.emp.pojo.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wuhan
 * @date 2019/12/22 23:29
 */
@Service
public class LoginValidImpl implements LoginValidService {
    @Resource
    private LoginValidMapper loginValidMapper;
    @Override
    public List<Emp> loginValid(Map<String, String> loginInfo) {
        return loginValidMapper.loginValid(loginInfo);
    }
}
