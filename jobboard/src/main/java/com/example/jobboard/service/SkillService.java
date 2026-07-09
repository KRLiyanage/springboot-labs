package com.example.jobboard.service;

import com.example.jobboard.entity.Skill;
import com.example.jobboard.exception.SkillNotFoundException;
import com.example.jobboard.repositories.SkillRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SkillService {
    private final SkillRepository skillRepository;


    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Transactional
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    @Transactional
    public void deleteById(Long id) {

        Skill skill = skillRepository.findById(id)
                .orElseThrow(SkillNotFoundException::new);

        skillRepository.delete(skill);
    }

    public List<Skill> findByCategory(String category) {
        return skillRepository.findByCategory(category);
    }

    public List<Skill> findByDemandLevel(String level) {
        return skillRepository.findByDemandLevel(level);
    }

    public List<Skill> findByName(String keyword) {
        return skillRepository.findByNameContaining(keyword);
    }

    public List<Skill> findBySalary(BigDecimal salary) {
        return skillRepository.findByAverageSalaryGreaterThanEqual(salary);
    }


}
