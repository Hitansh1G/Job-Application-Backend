package com.java.job.app.job;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job!=null)
            return job;
        return new Job(1L,"Test job","Test desc","200","300","test location");
    }

}
