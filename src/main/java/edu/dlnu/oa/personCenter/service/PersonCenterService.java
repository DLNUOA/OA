package edu.dlnu.oa.personCenter.service;

import edu.dlnu.oa.personCenter.dto.SaveUpdateDto;

import java.util.Map;

public interface PersonCenterService {
    public Map<String,Object> getPersonInfoById(int empId);

    public int updatePersonInfo(SaveUpdateDto saveUpdateDto);

    int sendValidEmail(String email);

    String getPersonPwdById(int empId);

    int setNewPwd(int empId, String newPwd);
}
