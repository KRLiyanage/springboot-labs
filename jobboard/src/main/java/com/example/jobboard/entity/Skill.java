package com.example.jobboard.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(max = 60)
    private String category;

    @Column(name ="demand level")
    @Size(max = 20)
    private String demandLevel;

    @Column(name = "average salary")
    private BigDecimal averageSalary;

    public Skill(String name, String category, String demandLevel, BigDecimal averageSalary) {
        this.name = name;
        this.category = category;
        this.demandLevel = demandLevel;
        this.averageSalary = averageSalary;
    }

    public Skill() {

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(BigDecimal averageSalary) {
        this.averageSalary = averageSalary;
    }

    public String getDemandLevel() {
        return demandLevel;
    }

    public void setDemandLevel(String demandLevel) {
        this.demandLevel = demandLevel;
    }
}
