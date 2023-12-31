package com.java.job.app.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <List<Job>> FindAll(){
        return ResponseEntity.ok(jobService.findALL());
    }

    @PostMapping(path = "/jobs", consumes = "application/json")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);

        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job>getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job!=null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        boolean delete = jobService.deleteJobById(id);
        if(delete){
            return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Job deletion failed",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateById(@PathVariable long id,
                                          @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id,updatedJob);
        if(updated)
            return new ResponseEntity<>("Job updated SUCCESSFULLY",HttpStatus.OK);
        return new ResponseEntity<>("job updation failed",HttpStatus.NOT_FOUND);
    }


//    public ResponseEntity<>

}
