package edu.dlnu.oa.systemManage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface SystemManagerMapper {
    @Select("SELECT *  FROM leave_request  \n" +
            "\tINNER JOIN emp  ON emp.`emp_id`= leave_request.`leave_staff_id` \n" +
            "\tWHERE leave_request.`dept_manager_id`=#{id}")
    List<Map<String, Object>> getDeptManagerLeaveRequest(int id);

    @Update("update leave_request set status=#{status},  approval_opinion=#{approvalOpinion}  where id = #{id}  ")
    int updateALeaveRequest(Map<String, Object> info);

    @Select("SELECT emp_name FROM emp WHERE emp_id = (  SELECT leave_staff_id FROM leave_request WHERE id  =#{id})")
    String getLeaveStaffName(Map<String, Object> info);

    @Select("SELECT emp_email FROM emp WHERE emp_id = (  SELECT leave_staff_id FROM leave_request WHERE id  =#{id})")
    String getLeaveStaffEmail(Map<String, Object> info);
}
