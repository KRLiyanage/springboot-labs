package com.example.jobboard.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class JobListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 150)
    private String title;

    @NotNull
    @Size(max = 120)
    private String companyName;

    @NotNull
    @Size(max = 100)
    private String location;

    @NotNull
    @Size(max = 20)
    private String employmentType;

    @Column(name = "salarymin")
    private BigDecimal salaryMin;

    @Column(name = "salarymax")
    private BigDecimal salaryMax;

    @NotNull
    @Column(name = " posteddate")
    private LocalDate postedDate;

    @NotNull
    @Size(max = 20)
    private String status;

    @Column(name = " requiredyears")
    private int requiredYears;

    public JobListing(String title, String companyName, String location, String employmentType, BigDecimal salaryMin, BigDecimal salaryMax, LocalDate postedDate, String status, int requiredYears) {
        this.title = title;
        this.companyName = companyName;
        this.location = location;
        this.employmentType = employmentType;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.postedDate = postedDate;
        this.status = status;
        this.requiredYears = requiredYears;
    }

    public JobListing() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public BigDecimal getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(BigDecimal salaryMin) {
        this.salaryMin = salaryMin;
    }

    public BigDecimal getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(BigDecimal salaryMax) {
        this.salaryMax = salaryMax;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRequiredYears() {
        return requiredYears;
    }

    public void setRequiredYears(int requiredYears) {
        this.requiredYears = requiredYears;
    }
}
