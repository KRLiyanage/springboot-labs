package com.example.reading_list;

import com.example.reading_list.model.Book;
import com.example.reading_list.model.ReadingStatus;
import com.example.reading_list.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReadingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(BookRepository bookRepository) {
		return args -> {
			bookRepository.save(new Book("Madol Doova", "Martin Wickramasinghe", "Fiction", 160, ReadingStatus.FINISHED, "Classic Sinhala novel."));
			bookRepository.save(new Book("Atomic Habits", "James Clear", "Self-Help", 320, ReadingStatus.READING, "Great insights on building habits."));
			bookRepository.save(new Book("Clean Code", "Robert C. Martin", "Technology", 464, ReadingStatus.WANT_TO_READ, "Must read for software developers."));
			bookRepository.save(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 310, ReadingStatus.FINISHED, "Enjoyed the adventure storyline."));
			bookRepository.save(new Book("1984", "George Orwell", "Dystopian", 328, ReadingStatus.WANT_TO_READ, null));

			System.out.println("Sample data inserted successfully!");
		};
	}
}