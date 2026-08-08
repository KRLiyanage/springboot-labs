package com.example.taskboard_start;

import com.example.taskboard_start.tasks.Task;
import com.example.taskboard_start.tasks.TaskRepository;
import com.example.taskboard_start.tasks.TaskStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TaskboardStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskboardStartApplication.class, args);
	}

	@Bean
    CommandLineRunner initDatabase(TaskRepository taskRepository) {
		return args -> {
			taskRepository.save(
					new Task("Study Java", TaskStatus.TODO, LocalDate.of(2026, 8, 10))
			);

			taskRepository.save(
					new Task("Complete Assignment", TaskStatus.IN_PROGRESS, LocalDate.of(2026, 8, 12))
			);

			taskRepository.save(
					new Task("Submit Project", TaskStatus.DONE, LocalDate.of(2026, 8, 15))
			);
		};
	}
}
