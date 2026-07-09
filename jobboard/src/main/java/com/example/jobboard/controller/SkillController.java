package com.example.jobboard.controller;

import com.example.jobboard.entity.Skill;
import com.example.jobboard.repositories.SkillRepository;
import com.example.jobboard.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService service;


    public SkillController(SkillService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Skill>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Skill> save(@RequestBody Skill skill){
        return new ResponseEntity<>(service.save(skill), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/category")
    public ResponseEntity<List<Skill>> findByCategory(@RequestParam String category) {
        return ResponseEntity.ok(service.findByCategory(category));
    }

    @GetMapping("/search/demand")
    public ResponseEntity<List<Skill>> findByDemand(@RequestParam String level) {
        return ResponseEntity.ok(service.findByDemandLevel(level));
    }

    @GetMapping("/search/salary")
    public ResponseEntity<List<Skill>> findBySalary(@RequestParam BigDecimal min) {
        return ResponseEntity.ok(service.findBySalary(min));
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<Skill>> findByName(@RequestParam String keyword) {
        return ResponseEntity.ok(service.findByName(keyword));
    }

}
