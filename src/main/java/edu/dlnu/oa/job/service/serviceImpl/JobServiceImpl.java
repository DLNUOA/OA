package edu.dlnu.oa.job.service.serviceImpl;

import edu.dlnu.oa.job.mapper.JobMapper;
import edu.dlnu.oa.job.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wuhan
 * @date 2019/12/31 9:48
 */
@Service
public class JobServiceImpl implements JobService {
    @Resource
    private JobMapper jobMapper;
    @Override
    public List<Map<String, Object>> getJobInfo() {
        return jobMapper.getJobInfo();
    }

    @Override
    public List<Map<String, Object>> getJobs() {
        return jobMapper.getJobs();
    }

    @Override
    public int postJob(Map<String, Object> job) {
        return jobMapper.postJob(job);
    }

    @Override
    public int deleteJobById(int id) {
        return jobMapper.deleteJobById(id);
    }

    @Override
    public int putJob(Map<String, Object> job) {
        return jobMapper.putJob(job);
    }
}
