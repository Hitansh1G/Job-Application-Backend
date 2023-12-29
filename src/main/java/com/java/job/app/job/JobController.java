package com.java.job.app.job;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping("/jobs")
    public List<Job> FindAll(){
        return jobService.findALL();
    }

    @PostMapping(path = "/jobs")
    public String createJob(@RequestBody Job job){
        jobService.createJob(job);
        return "Job added SUCCESSFULLY";
    }
}
