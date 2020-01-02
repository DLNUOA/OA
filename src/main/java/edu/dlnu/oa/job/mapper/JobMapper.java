package edu.dlnu.oa.job.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface JobMapper {
    @Select("select job_id,job_name from job where job_id > 0")
    List<Map<String, Object>> getJobInfo();
}
