package com.example.taskboard_start.tasks;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class TaskForm {

    @NotBlank(message = "Title is required")
    private String title;

    private String status;

    private LocalDate dueDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
