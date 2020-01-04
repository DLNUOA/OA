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

    int likeEmp(Integer empId);

    int dislikeEmp(Integer empId);

    List<Map<String, Object>> getEvaluate();

    List<Map<String, Object>> getBaoXiaoApplyLogByEmpId(int empId);

    int findDeptMByEmpId(int empId);

    int findCashIdByEmpId(int empId);

    Map<String, Object> getBaoXiaoApplyLogJilu(int id);

    void postABaoXiaoApply(int empId, String purpose, String amount, int deptMId, int cashId);

    void postABaoXiaoApplyToLog(int claimId);

    int getMaxClaimIdByEmpId(int empId);

    List<Map<String, Object>> getDeptBaoXiaoApply(int empId);

    List<Map<String, Object>> getCashBaoXiaoApply(int empId);

    int DeptUpdateBaoXiaoLog(Map<String, Object> info);

    void DeptUpdateBaoXiaoLogToClaim(Map<String, Object> info);

    int CashUpdateBaoXiaoLog(Map<String, Object> info);

    void CashUpdateBaoXiaoLogToClaim(Map<String, Object> info);

    void setPass(Map<String, Object> info);

    int getJobIdByEmpId(int empId);

    Map<String, Object> loglog(int id);
}
