package edu.dlnu.oa.job.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface JobMapper {
    @Select("select job_id,job_name from job where job_id > 0")
    List<Map<String, Object>> getJobInfo();

    @Select("SELECT job_id jobId,job_name jobName,job_min_sal jobMinSalary,job_max_sal jobMaxSalary FROM job WHERE job_id > 0")
    List<Map<String, Object>> getJobs();

    @Insert("insert into job (job_id,job_name,job_min_sal,job_max_sal) values" +
            "(default,#{jobName},#{jobMinSalary},#{jobMaxSalary})")
    int postJob(Map<String, Object> job);

    @Delete("delete from job where job_id = #{id} ")
    int deleteJobById(int id);

    @Update("update job set  job_name=#{jobName},job_min_sal=#{jobMinSalary},job_max_sal=#{jobMaxSalary} where job_id=#{jobId} ")
    int putJob(Map<String, Object> job);
}
