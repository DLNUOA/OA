package edu.dlnu.oa.personCenter.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PersonCenterMapper {
//    @Select("SELECT  ed.login_name,ed.name,ed.dept_name,job.`name`,ed.gender,ed.birthday,ed.tel,ed.email,ed.qq,ed.intro\n" +
//            "FROM job\n" +
//            "INNER JOIN (\n" +
//            "\tSELECT\n" +
//            "\temp.`login_name` login_name,emp.`name` NAME,dept.`name` dept_name,emp.`gender` gender,emp.`birthday` birthday,\n" +
//            "\temp.`tel` tel,emp.`email` email,emp.`qq` qq,emp.`intro` intro,emp.`job_id` job_id\n" +
//            "\tFROM emp\n" +
//            "\tINNER JOIN dept ON emp.`dept_id`=dept.`id`\n" +
//            "\tWHERE emp.`id` = #{empId} " +
//            ")ed ON job.`id` = ed.job_id")
    @Select("SELECT  DISTINCT  *  FROM emp e,job j,dept d\n" +
            "WHERE e.emp_id=#{empId} and e.emp_job_id = j.job_id AND e.emp_dept_id = d.dept_id")
    List<Map<String,Object>> getEmpInfoById(int empId);
}
