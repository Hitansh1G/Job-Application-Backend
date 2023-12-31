package com.java.job.app.Company;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.java.job.app.Review.Review;
import com.java.job.app.job.Job;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private List<Job> job;

    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private List<Review>reviews;

    public Company(Long id, String name, String description, List<Job> job) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.job = job;
    }

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJob() {
        return job;
    }

    public void setJob(List<Job> job) {
        this.job = job;
    }
}
