package com.example.reading_list.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookForm {

    @NotBlank(message = "Title must not be blank")
    private String title;

    @NotBlank(message = "Author must not be blank")
    private String author;

    @NotBlank(message = "Genre must not be blank")
    private String genre;

    @Min(value = 1, message = "Pages must be at least 1")
    private int pages = 1;

    @NotNull(message = "Reading status is required")
    private ReadingStatus readingStatus;

    private String notes;

    // Constructors
    public BookForm() {}

    public BookForm(String title, String author, String genre, int pages, ReadingStatus readingStatus, String notes) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.readingStatus = readingStatus;
        this.notes = notes;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public ReadingStatus getReadingStatus() { return readingStatus; }
    public void setReadingStatus(ReadingStatus readingStatus) { this.readingStatus = readingStatus; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}