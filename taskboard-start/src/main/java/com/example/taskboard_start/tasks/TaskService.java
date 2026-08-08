package com.example.taskboard_start.tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public List<Task> findByStatus(TaskStatus status){
        return taskRepository.findByStatus(status);
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }

}
