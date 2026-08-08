package com.example.taskboard_start.tasks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByStatus(TaskStatus status);
}
