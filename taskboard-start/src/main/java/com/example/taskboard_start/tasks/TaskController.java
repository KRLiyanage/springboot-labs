package com.example.taskboard_start.tasks;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAll(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> getById(@PathVariable Long id){
        return taskService.findById(id);
    }

    @PostMapping
    public Task save(@RequestBody Task task){
        return taskService.save(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getByStatus(@PathVariable TaskStatus status){
        return taskService.findByStatus(status);
    }

    @DeleteMapping("/{id}")
    public void deletById(@PathVariable Long id){
         taskService.deleteById(id);
    }


}
