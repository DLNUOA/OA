package edu.dlnu.oa.mapper;

import edu.dlnu.oa.dept.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface Index {
    @Select("select username,password  from user where username = #{condition.username} and password =  #{condition.password}")
    List<Map<String, String>> loginValid(@Param("condition") Map<String, String> userInfo);

    @Update("UPDATE rank SET score=#{condition.score} WHERE uid = #{condition.username} ;")
    boolean submitScore(@Param("condition") Map<String, String> submitInfo);

    @Insert("INSERT INTO rank  (uid,score) VALUES(#{condition.username} ,#{condition.score});")
    boolean insertScore(@Param("condition") Map<String, String> submitInfo);
    @Select("select count(*) from rank where uid = #{condition.username} ")
    int isCreated(@Param("condition") Map<String, String> submitInfo);

    @Insert("insert into user (username,password) values( #{condition.username} ,  #{condition.password})")
    boolean signUp(@Param("condition") Map<String, String> submitInfo);

    @Select("SELECT uid,score from rank")
    List<Map<String, String>> getRankList();

    @Select("select count(*) from dept")
    int getCount();

    @Select("select * from dept")
    List<Dept> getAllDept();


//    @Select("select dept_id deptID,dept_name deptName,dept_address deptAddress from dept")
//    List<Dept> getAllDept();
}