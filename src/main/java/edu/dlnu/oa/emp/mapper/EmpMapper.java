package edu.dlnu.oa.emp.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    @Select("SELECT * FROM emp,dept,job WHERE emp.`emp_dept_id`=dept.`dept_id` AND emp.`emp_job_id` = job.`job_id`")
    List<Map<String,Object>> getEmpInfo();



    /**
     * empName: "wuhan"
     * empLoginName: "wuhan"
     * selectedDept: 1
     * selectedGender: "男"
     * selectedJob: 1
     * email: "905284451@qq.com"
     * tel: "1999"
     * hiredate: "1999-09-14"
     * salary:1
     * @param emp
     * @return
     */
    @Insert("INSERT INTO emp (emp_id,emp_name,emp_login_name,emp_dept_id," +
            "emp_gender,emp_job_id,emp_email,emp_phone, emp_hiredate,emp_salary,emp_pwd,emp_role_id) " +
            "VALUES (DEFAULT,#{empName},#{empLoginName},#{selectedDept}," +
            "#{selectedGender},#{selectedJob},#{email},#{tel},#{hiredate},#{salary},123456,2)")
    int postAEmp(Map<String, Object> emp);
}
