package com.example.taskboard_start.tasks;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/new")
    public String newTaskForm(Model model) {
        model.addAttribute("taskForm", new TaskForm());
        return "tasks/form";
    }

    @PostMapping
    public String createTask(
            @Valid @ModelAttribute("taskForm") TaskForm form,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "tasks/form";
        }

        Task task = new Task();
        task.setTitle(form.getTitle());
        task.setStatus(form.getStatus());
        task.setDueDate(form.getDueDate());

        taskService.save(task);

        redirectAttributes.addFlashAttribute(
                "success",
                "Task created successfully."
        );

        return "redirect:/tasks";
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
