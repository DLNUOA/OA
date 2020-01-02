package edu.dlnu.oa.job.controller;

import edu.dlnu.oa.job.service.JobService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author wuhan
 * @date 2019/12/31 9:47
 */
@RestController
@RequestMapping("/api")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobInfo")
    public List<Map<String,Object>> jobInfo(HttpServletRequest request){

        return jobService.getJobInfo();
    }

    @GetMapping("/job")
    public List<Map<String,Object>> getJobs(HttpServletRequest request){
        return jobService.getJobs();
    }
    @PostMapping("/job")
    public int postJob(HttpServletRequest request, @RequestBody Map<String,Object> job){
        return jobService.postJob(job);
    }

    @DeleteMapping("/job/{id}")
    public int deleteJobById(HttpServletRequest request,@PathVariable("id") int id){
        return jobService.deleteJobById(id);
    }
    @PutMapping("/job")
    public int putJob(HttpServletRequest request,@RequestBody Map<String,Object> job){
        return  jobService.putJob(job);
    }


}
