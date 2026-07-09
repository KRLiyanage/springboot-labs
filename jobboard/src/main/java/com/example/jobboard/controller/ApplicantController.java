package com.example.jobboard.controller;

import com.example.jobboard.entity.Applicant;
import com.example.jobboard.service.ApplicantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    private final ApplicantService service;


    public ApplicantController(ApplicantService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Applicant>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Applicant> register(@RequestBody Applicant applicant){
        return new ResponseEntity<>(service.register(applicant), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/country")
    public ResponseEntity<List<Applicant>> findByCountry(@RequestParam String country) {
        return ResponseEntity.ok(service.findByCountry(country));
    }

    @GetMapping("/search/status")
    public ResponseEntity<List<Applicant>> findByStatus(@RequestParam String status) {
        return ResponseEntity.ok(service.findByStatus(status));
    }

    @GetMapping("/search/experience")
    public ResponseEntity<List<Applicant>> findByExperience(@RequestParam int minYears) {
        return ResponseEntity.ok(service.findByExperience(minYears));
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<Applicant>> findByName(@RequestParam String keyword) {
        return ResponseEntity.ok(service.findByName(keyword));
    }

}
