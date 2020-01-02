package edu.dlnu.oa.job.controller;

import edu.dlnu.oa.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private List<Map<String,Object>> jobInfo(HttpServletRequest request){

        return jobService.getJobInfo();
    }
}
