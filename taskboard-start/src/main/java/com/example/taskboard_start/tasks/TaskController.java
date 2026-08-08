package com.example.taskboard_start.tasks;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String listTasks(Model model){
        model.addAttribute("tasks",taskService.findAll());
        return "tasks/list";
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
