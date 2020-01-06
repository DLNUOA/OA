package edu.dlnu.oa.job.service;

import java.util.List;
import java.util.Map;

public interface JobService {
    List<Map<String, Object>> getJobInfo();

    List<Map<String, Object>> getJobs();

    int postJob(Map<String, Object> job);

    int deleteJobById(int id);

    int putJob(Map<String, Object> job);
}
