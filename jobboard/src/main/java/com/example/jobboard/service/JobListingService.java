package com.example.jobboard.service;

import com.example.jobboard.entity.JobListing;
import com.example.jobboard.exception.InvalidSalaryRangeException;
import com.example.jobboard.exception.JobListingNotFoundException;
import com.example.jobboard.repositories.JobListingRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class JobListingService {

    private final JobListingRepository jobListingRepository;


    public JobListingService(JobListingRepository jobListingRepository) {
        this.jobListingRepository = jobListingRepository;
    }

    @Transactional
    public List<JobListing> findAll(){
        return jobListingRepository.findAll();
    }

    public JobListing getById(Long id){
        return jobListingRepository.findById(id).orElseThrow(JobListingNotFoundException::new);
    }

    public JobListing save(JobListing jobListing){
        if(jobListing.getSalaryMax().compareTo(jobListing.getSalaryMin())<0){
            throw new InvalidSalaryRangeException();
        }
        return jobListingRepository.save(jobListing);
    }

    public void deleteById(Long id){
        JobListing jobListing = jobListingRepository.findById(id).orElseThrow(JobListingNotFoundException::new);

        jobListingRepository.deleteById(id);
    }

    public List<JobListing> findByStatus(String status) {
        return jobListingRepository.findByStatus(status);
    }

    public List<JobListing> findByEmploymentType(String type) {
        return jobListingRepository.findByEmploymentType(type);
    }

    public List<JobListing> findByCompany(String keyword) {
        return jobListingRepository.findByCompanyNameContaining(keyword);
    }

    public List<JobListing> findByLocation(String location) {
        return jobListingRepository.findByLocation(location);
    }

    public List<JobListing> findBySalary(BigDecimal min) {
        return jobListingRepository.findBySalaryMinGreaterThanEqual(min);
    }

    public List<JobListing> findByExperience(int years) {
        return jobListingRepository.findByRequiredYearsLessThanEqual(years);
    }




}
