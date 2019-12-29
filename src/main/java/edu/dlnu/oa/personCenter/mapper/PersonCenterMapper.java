package edu.dlnu.oa.personCenter.mapper;

import edu.dlnu.oa.personCenter.dto.SaveUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

}
