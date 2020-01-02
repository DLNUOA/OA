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

    @Select("SELECT    NAME,login_name,job_id,job_name,job_min_sal,job_max_sal,dept_name,gender,hiredate,tel,email,intro\n" +
            "FROM job\n" +
            "INNER JOIN (\n" +
            "\tSELECT\n" +
            "\temp.`emp_login_name` login_name,emp.`emp_name` NAME,dept.`dept_name` dept_name,emp.`emp_gender` gender,emp.`emp_hiredate` hiredate,\n" +
            "\temp.`emp_phone` tel,emp.`emp_email` email,emp.`emp_info` intro,emp.`emp_job_id` emp_job_id\n" +
            "\tFROM emp   \n" +
            "\tINNER JOIN dept ON emp.`emp_dept_id`=dept.`dept_id`\n" +
            ")ed ON  job.`job_id`=ed.emp_job_id")
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

}
