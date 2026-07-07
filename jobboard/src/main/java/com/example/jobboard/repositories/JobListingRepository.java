package com.example.jobboard.repositories;

import com.example.jobboard.entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface JobListingRepository extends JpaRepository<JobListing,Long> {

    List<JobListing> findByStatus(String status);

    List<JobListing> findByEmploymentType(String employmentType);

    List<JobListing> findByCompanyNameContaining(String keyword);

    List<JobListing> findByLocation(String location);

    List<JobListing> findBySalaryMinGreaterThanEqual(BigDecimal salary);

    List<JobListing> findByRequiredYearsLessThanEqual(int years);
}
