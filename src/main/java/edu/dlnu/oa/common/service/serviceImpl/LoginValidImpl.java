package edu.dlnu.oa.common.service.serviceImpl;

import edu.dlnu.oa.common.mapper.LoginValidMapper;
import edu.dlnu.oa.common.service.LoginValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public int loginValid(Map<String, String> loginInfo) {
        int i = loginValidMapper.loginValid(loginInfo);
        if (i==1){
            return 1;
        }
        else {
            return 0;
        }
    }
}
