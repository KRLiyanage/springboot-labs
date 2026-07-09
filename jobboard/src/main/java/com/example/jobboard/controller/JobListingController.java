package com.example.jobboard.controller;

import com.example.jobboard.entity.JobListing;
import com.example.jobboard.service.JobListingService;
import jakarta.persistence.criteria.ListJoin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/listings")
public class JobListingController {

    private final JobListingService service;

    public JobListingController(JobListingService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<JobListing>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobListing> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<JobListing> save(@RequestBody JobListing jobListing){
        return new ResponseEntity<>(service.save(jobListing), HttpStatus.CREATED);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
   }

   @GetMapping("/search/stutas")
    public ResponseEntity<List<JobListing>> findByStatus(@RequestParam String status){
        return ResponseEntity.ok(service.findByStatus(status));
   }

   @GetMapping("/search/type")
    public ResponseEntity<List<JobListing>> findByType(@RequestParam String type){
        return ResponseEntity.ok(service.findByEmploymentType(type));
   }

   @GetMapping("/search/salary")
    public ResponseEntity<List<JobListing>> findBySalay(@RequestParam BigDecimal min){
        return ResponseEntity.ok(service.findBySalary(min));
   }

    @GetMapping("/search/company")
    public ResponseEntity<List<JobListing>> findByCompany(@RequestParam String keyword) {
        return ResponseEntity.ok(service.findByCompany(keyword));
    }

    @GetMapping("/search/location")
    public ResponseEntity<List<JobListing>> findByLocation(@RequestParam String location) {
        return ResponseEntity.ok(service.findByLocation(location));
    }

    @GetMapping("/search/experience")
    public ResponseEntity<List<JobListing>> findByExperience(@RequestParam int maxYears) {
        return ResponseEntity.ok(service.findByExperience(maxYears));
    }

}
