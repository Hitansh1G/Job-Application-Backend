package com.java.job.app.job;

import java.util.List;

public interface JobService {
    List<Job>findALL();
    void createJob(Job job);
}
