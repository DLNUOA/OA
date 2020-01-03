package edu.dlnu.oa.personCenter.service;

import edu.dlnu.oa.personCenter.dto.SaveUpdateDto;

import java.util.List;
import java.util.Map;

public interface PersonCenterService {
    public Map<String,Object> getPersonInfoById(int empId);

    public int updatePersonInfo(SaveUpdateDto saveUpdateDto);

    int sendValidEmail(String email);

    String getPersonPwdById(int empId);

    int setNewPwd(int empId, String newPwd);

    int upMyAvatar(int empId, String avatar);

    String getMyAvatar(int empId);

    List<Map<String, Object>> getAB();

    Map<String,Object> getDeptManagerInfoByApplyRequesterId(int requesterId);

    int launchALeaveRequest(Map<String, Object> leaveRequestInfo);

    List<Map<String, Object>> getLeaveRequest(int requesterId);

    String getEmpNameById(int id);

    int deleteLeaveRequestById(int id);

    List<Map<String, Object>> getDeptManagerLeaveRequest(int id);
}
