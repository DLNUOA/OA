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

    @Override
    public Map<String, Object> getDeptManagerInfoByApplyRequesterId(int requesterId) {
        return personCenterMapper.getDeptManagerInfoByApplyRequesterId(requesterId);
    }

    @Override
    public int launchALeaveRequest(Map<String, Object> leaveRequestInfo) {
        return personCenterMapper.launchALeaveRequest(leaveRequestInfo);
    }

    @Override
    public List<Map<String, Object>> getLeaveRequest(int requesterId) {
        return personCenterMapper.getLeaveRequest(requesterId);
    }

    @Override
    public String getEmpNameById(int id) {
        return personCenterMapper.getEmpNameById(id);
    }

    @Override
    public int deleteLeaveRequestById(int id) {
        return personCenterMapper.deleteLeaveRequestById(id);
    }

    @Override
    public List<Map<String, Object>> getDeptManagerLeaveRequest(int id) {
        return personCenterMapper.getDeptManagerLeaveRequest(id);
    }

    @Override
    public int likeEmp(Integer empId) {
        int flag =  personCenterMapper.existLikedEmp(empId);
        if (flag==0){
            return personCenterMapper.likeEmpInit(empId);
        }else {
            return personCenterMapper.likeEmp(empId);
        }
    }

    @Override
    public int dislikeEmp(Integer empId) {
        int flag =  personCenterMapper.existDislikedEmp(empId);
        if (flag==0){
            return personCenterMapper.dislikeEmpInit(empId);
        }else {
            return personCenterMapper.dislikeEmp(empId);
        }
    }

    @Override
    public List<Map<String, Object>> getEvaluate() {
        return personCenterMapper.getEvaluate();
    }

    @Override
    public List<Map<String, Object>> getBaoXiaoApplyLogByEmpId(int empId) {
        return personCenterMapper.getBaoXiaoApplyLogByEmpId(empId);
    }

    @Override
    public int findDeptMByEmpId(int empId) {
        return personCenterMapper.findDeptMByEmpId(empId);
    }

    @Override
    public int findCashIdByEmpId(int empId) {
        return personCenterMapper.findCashIdByEmpId(empId);
    }

    @Override
    public Map<String, Object> getBaoXiaoApplyLogJilu(int id) {
        return personCenterMapper.getBaoXiaoApplyLogJilu(id);
    }

    @Override
    public void postABaoXiaoApply(int empId, String purpose, String amount, int deptMId, int cashId) {
         personCenterMapper.postABaoXiaoApply(empId,purpose,amount,deptMId,cashId);
    }

    @Override
    public void postABaoXiaoApplyToLog(int claimId) {
        personCenterMapper.postABaoXiaoApplyToLog(claimId);
    }

    @Override
    public int getMaxClaimIdByEmpId(int empId) {

        return personCenterMapper.getMaxClaimIdByEmpId(empId);
    }

    @Override
    public List<Map<String, Object>> getDeptBaoXiaoApply(int empId) {
        return personCenterMapper.getDeptBaoXiaoApply(empId);
    }

    @Override
    public List<Map<String, Object>> getCashBaoXiaoApply(int empId) {
        return personCenterMapper.getCashBaoXiaoApply(empId);
    }

    @Override
    public int DeptUpdateBaoXiaoLog(Map<String, Object> info) {
        return personCenterMapper.DeptUpdateBaoXiaoLog(info);
    }

    @Override
    public void DeptUpdateBaoXiaoLogToClaim(Map<String, Object> info) {
         personCenterMapper.DeptUpdateBaoXiaoLogToClaim(info);
    }

    @Override
    public int CashUpdateBaoXiaoLog(Map<String, Object> info) {
        return personCenterMapper.CashUpdateBaoXiaoLog(info);
    }

    @Override
    public void CashUpdateBaoXiaoLogToClaim(Map<String, Object> info) {
        personCenterMapper.CashUpdateBaoXiaoLogToClaim(info);
    }

    @Override
    public void setPass(Map<String, Object> info) {
        personCenterMapper.setPass(info);
    }

    @Override
    public int getJobIdByEmpId(int empId) {
        return personCenterMapper.getJobIdByEmpId(empId);
    }

    @Override
    public Map<String, Object> loglog(int id) {
        return personCenterMapper.loglog(id);
    }
}
