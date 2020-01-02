package edu.dlnu.oa.personCenter.service.serviceImpl;

import edu.dlnu.oa.personCenter.dto.SaveUpdateDto;
import edu.dlnu.oa.personCenter.mapper.PersonCenterMapper;
import edu.dlnu.oa.personCenter.service.PersonCenterService;
import edu.dlnu.oa.utils.MailUtils;
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
    public Map<String, Object> getPersonInfoById(int empId) {
        return personCenterMapper.getEmpInfoById(empId);
    }

    @Override
    public int updatePersonInfo(SaveUpdateDto saveUpdateDto) {
        return personCenterMapper.updateEmpInfo(saveUpdateDto);
    }

    @Override
    public int sendValidEmail(String email) {
        int code = (int)((Math.random()*9+1)*100000);
        MailUtils.sendMail(email,String.valueOf(code),"OA验证码");
        return code;
    }

    @Override
    public String getPersonPwdById(int empId) {
        return personCenterMapper.getPersonPwdById(empId);
    }

    @Override
    public int setNewPwd(int empId, String newPwd) {
        return personCenterMapper.setNewPwd(empId,newPwd);
    }

    @Override
    public int upMyAvatar(int empId, String avatar) {
        return personCenterMapper.upMyAvatar(empId,avatar);
    }

    @Override
    public String getMyAvatar(int empId) {
        return personCenterMapper.getMyAvatar(empId);
    }

    @Override
    public List<Map<String, Object>> getAB() {
        return personCenterMapper.getAddressBook();
    }
}
