package com.example.jobboard.repositories;

import com.example.jobboard.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {

    List<Skill> findByCategory(String category);

    List<Skill> findByDemandLevel(String demandLevel);

    List<Skill> findByNameContaining(String keyword);

    List<Skill> findByAverageSalaryGreaterThanEqual(BigDecimal salary);
}
