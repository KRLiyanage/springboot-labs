package com.example.jobboard.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 120)
    private String fullName;

    @NotNull
    @Size(max = 180)
    private String email;

    @Size(max = 20)
    private String phone;

    @NotNull
    @Size(max = 60)
    private String country;

    @Column(name = "yearsofexperience")
    private int yearsOfExperience;

    @NotNull
    @Size(max = 20)
    private String status;

    public Applicant(String fullName, String email, String phone, String country, int yearsOfExperience, String status) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.yearsOfExperience = yearsOfExperience;
        this.status = status;
    }


    public Applicant() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
