package edu.dlnu.oa.personCenter.mapper;

import edu.dlnu.oa.personCenter.dto.SaveUpdateDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface PersonCenterMapper {

    @Select("SELECT  NAME,login_name,job_id,job_name,job_min_sal,job_max_sal,dept_name,gender,hiredate,tel,email,intro\n" +
            "FROM job\n" +
            "INNER JOIN (\n" +
            "\tSELECT\n" +
            "\temp.`emp_login_name` login_name,emp.`emp_name` NAME,dept.`dept_name` dept_name,emp.`emp_gender` gender,emp.`emp_hiredate` hiredate,\n" +
            "\temp.`emp_phone` tel,emp.`emp_email` email,emp.`emp_info` intro,emp.`emp_job_id` emp_job_id\n" +
            "\tFROM emp\n" +
            "\tINNER JOIN dept ON emp.`emp_dept_id`=dept.`dept_id`\n" +
            "\tWHERE emp.`emp_id` = #{empId}  \n" +
            ")ed ON  job.`job_id`=ed.emp_job_id")
    Map<String,Object> getEmpInfoById(int empId);


    @Update("UPDATE emp \n" +
            "SET     emp.`emp_login_name` = #{loginName} ,\n" +
            "\temp.`emp_phone` = #{tel},\n" +
            "\temp.`emp_email` = #{email},\n" +
            "\temp.`emp_info` = #{intro}\n" +
            "WHERE emp.`emp_id` = #{empId}")
    int updateEmpInfo(SaveUpdateDto saveUpdateDto);

    @Select("select emp_pwd from emp where emp_id = #{empId} ")
    String getPersonPwdById(int empId);

    @Update("update emp set emp_pwd = #{newPwd} where emp_id = #{empId} ")
    int setNewPwd(@Param("empId") int empId, @Param("newPwd") String newPwd);


    @Update("update emp set emp_pic = #{avatar} where emp_id = #{empId} ")
    int upMyAvatar(@Param("empId") int empId,@Param("avatar") String avatar);

    @Select("select emp_pic from emp where emp_id = #{empId}")
    String getMyAvatar(int empId);

    @Select("\n" +
            "SELECT * FROM like_dislike_count \n" +
            "\n" +
            "INNER JOIN (\n" +
            "\n" +
            "\n" +
            "\n" +
            "SELECT id,\n" +
            "         NAME,\n" +
            "         login_name,\n" +
            "         job_id,\n" +
            "         job_name,\n" +
            "         job_min_sal,\n" +
            "         job_max_sal,\n" +
            "         dept_name,\n" +
            "         gender,\n" +
            "         hiredate,\n" +
            "         tel,\n" +
            "         email,\n" +
            "         intro\n" +
            "FROM job\n" +
            "INNER JOIN \n" +
            "    (SELECT emp.`emp_login_name` login_name,\n" +
            "         emp.`emp_name` NAME,\n" +
            "         dept.`dept_name` dept_name,\n" +
            "         emp.`emp_gender` gender,\n" +
            "         emp.`emp_hiredate` hiredate,\n" +
            "         emp.`emp_phone` tel,\n" +
            "         emp.emp_id id ,\n" +
            "         emp.`emp_email` email,\n" +
            "         emp.`emp_info` intro,\n" +
            "         emp.`emp_job_id` emp_job_id\n" +
            "    FROM emp\n" +
            "    INNER JOIN dept\n" +
            "        ON emp.`emp_dept_id`=dept.`dept_id` )ed\n" +
            "    ON job.`job_id`=ed.emp_job_id ) ee ON like_dislike_count.`emp_id`=ee.id")
    List<Map<String,Object>> getAddressBook();



    @Select("SELECT emp_id,emp_name,emp_email\n" +
            "FROM emp WHERE emp_job_id=3  AND   emp_dept_id =   \n" +
            "    (SELECT emp_dept_id FROM emp e WHERE emp_id=#{id}  )  ")
    Map<String,Object> getDeptManagerInfoByApplyRequesterId(int id);

    @Insert("INSERT INTO leave_request (id,dept_manager_id,begin_date,end_date,STATUS,request_date,leave_staff_id,reason)\n" +
            "VALUES(DEFAULT,#{deptManagerId},#{beginDate},#{endDate},'待审批',NOW(),#{requestStaffId},#{reason})")
    int launchALeaveRequest(Map<String, Object> info);

    @Select("SELECT * FROM leave_request,emp WHERE leave_staff_id = #{requesterId} AND emp_id=dept_manager_id")
    List<Map<String, Object>> getLeaveRequest(int requesterId);

    @Select("select emp_name from emp where emp_id = #{id}")
    String getEmpNameById(int id);

    @Delete("delete from  leave_request where id = #{id}")
    int deleteLeaveRequestById(int id);

    @Select("SELECT *  FROM leave_request  \n" +
            "\tINNER JOIN emp  ON emp.`emp_id`= leave_request.`leave_staff_id` \n" +
            "\tWHERE leave_request.`dept_manager_id`=#{id}")
    List<Map<String, Object>> getDeptManagerLeaveRequest(int id);

    @Select("SELECT COUNT(*)  FROM like_dislike_count WHERE emp_id = #{empId}")
    int existLikedEmp(Integer empId);

    @Insert("INSERT INTO like_dislike_count (emp_id) VALUES (#{empId});")
    int likeEmpInit(Integer empId);

    @Update("UPDATE like_dislike_count SET like_count = like_count+1 WHERE emp_id=#{empId}")
    int likeEmp(Integer empId);

    @Select("SELECT COUNT(*)  FROM like_dislike_count WHERE emp_id = #{empId}")
    int existDislikedEmp(Integer empId);

    @Insert("INSERT INTO like_dislike_count (emp_id) VALUES (#{empId});")
    int dislikeEmpInit(Integer empId);

    @Update("UPDATE like_dislike_count SET dislike_count = dislike_count+1 WHERE emp_id=#{empId}")
    int dislikeEmp(Integer empId);

    @Select("select * from  like_dislike_count ")
    List<Map<String, Object>> getEvaluate();

    @Select("SELECT * FROM claim WHERE claim.`apply_emp_id` = #{empId}")
    List<Map<String, Object>> getBaoXiaoApplyLogByEmpId(int empId);

    @Select("SELECT emp_id\n" +
            "FROM emp WHERE emp_job_id=3  AND   emp_dept_id =   \n" +
            "    (SELECT emp_dept_id FROM emp e WHERE emp_id=#{empId})")
    int findDeptMByEmpId(int empId);

    @Select("SELECT emp_id\n" +
            "FROM emp WHERE emp_job_id=11  AND   emp_dept_id =   \n" +
            "    (SELECT emp_dept_id FROM emp e WHERE emp_id=#{empId})")
    int findCashIdByEmpId(int empId);

    @Select("SELECT * FROM claim_log WHERE  claim_log.`claim_id` = #{id}  \n")
    Map<String, Object> getBaoXiaoApplyLogJilu(int id);

    @Insert("INSERT INTO claim (apply_emp_id,purpose,amount,dept_managerId,cashier_id,lunch_date)\n" +
            " VALUES(#{empId},#{purpose},#{amount},#{deptMId},#{cashId},NOW())")
    void postABaoXiaoApply(int empId, String purpose, String amount, int deptMId, int cashId);

    @Insert("INSERT INTO claim_log (claim_id) VALUES (#{claimId})\n")
    void postABaoXiaoApplyToLog(int claimId);

    @Select("SELECT MAX(id) FROM claim  WHERE claim.`apply_emp_id` = #{empId}\n")
    int getMaxClaimIdByEmpId(int empId);

    @Select("SELECT * FROM claim  INNER JOIN emp ON claim.`apply_emp_id` = emp.`emp_id`     WHERE claim.`dept_managerId` = #{empId} \n \n")
    List<Map<String, Object>> getDeptBaoXiaoApply(int empId);

    @Select("SELECT * FROM claim WHERE claim.`cashier_id` = #{empId} AND flag = 1\n")
    List<Map<String, Object>> getCashBaoXiaoApply(int empId);

    @Update("UPDATE claim_log SET dept_opinion=#{deptOpinion} ,dept_result=#{deptResult},dept_exec_time=NOW() WHERE claim_log.`claim_id` =  #{claimId}")
    int DeptUpdateBaoXiaoLog(Map<String, Object> info);

    @Update("UPDATE claim SET flag = 1 WHERE claim.`id` = #{claimId}  \n")
    void DeptUpdateBaoXiaoLogToClaim(Map<String, Object> info);

    @Update("UPDATE claim_log SET cash_opinion=#{cashOpinion} ,cash_result=#{cashResult},cash_exec_time=NOW() WHERE claim_log.`claim_id` = #{claimId}  \n")
    int CashUpdateBaoXiaoLog(Map<String, Object> info);

    @Update("UPDATE claim SET claim.`status` = '财务通过，已报销' WHERE claim.`id` = #{claimId}   \n")
    void CashUpdateBaoXiaoLogToClaim(Map<String, Object> info);

    @Update("UPDATE claim  SET claim.`status`='部门经理已经通过，待出纳财务报销' WHERE claim.`id` = #{claimId} ")
    void setPass(Map<String, Object> info);

    @Select("SELECT emp_job_id FROM emp WHERE emp.`emp_id` = #{empId}")
    int getJobIdByEmpId(int empId);

    @Select("SELECT * FROM claim_log WHERE  claim_log.`claim_id` = #{id}")
    Map<String, Object> loglog(int id);
}
