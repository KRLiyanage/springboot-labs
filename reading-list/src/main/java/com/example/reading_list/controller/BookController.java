package com.example.reading_list.controller;


import com.example.reading_list.model.Book;
import com.example.reading_list.model.BookForm;
import com.example.reading_list.service.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String listBook(Model model){
        model.addAttribute("books",bookService.findAll());
        return "books/list";
    }

    @GetMapping("/new")
    public String showNewBookForm(Model model) {
        model.addAttribute("bookForm", new BookForm());
        model.addAttribute("formAction", "/books");
        return "books/form";
    }

    @GetMapping("/{id}")
    public String bookDetail(@PathVariable Long id,Model model){
        Book book = bookService.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book",book);
        return "books/detail";
    }

    @PostMapping
    public String createBook(@Valid @ModelAttribute("bookForm") BookForm bookForm,
                             BindingResult bindingResult,
                             Model model,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("formAction", "/books");
            return "books/form";
        }

        Book book = new Book(
                bookForm.getTitle(),
                bookForm.getAuthor(),
                bookForm.getGenre(),
                bookForm.getPages(),
                bookForm.getReadingStatus(),
                bookForm.getNotes()
        );
        bookService.save(book);

        redirectAttributes.addFlashAttribute("successMessage", "Book added successfully!");
        return "redirect:/books";
    }

    // GET /books/{id}/edit - Pre-populated form
    @GetMapping("/{id}/edit")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));

        BookForm bookForm = new BookForm(
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getPages(),
                book.getReadingStatus(),
                book.getNotes()
        );

        model.addAttribute("bookForm", bookForm);
        model.addAttribute("formAction", String.format("/books/%d", id));
        return "books/form";
    }

    // POST /books/{id} - Process update
    @PostMapping("/{id}")
    public String updateBook(@PathVariable Long id,
                             @Valid @ModelAttribute("bookForm") BookForm bookForm,
                             BindingResult bindingResult,
                             Model model,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("formAction", String.format("/books/%d", id));
            return "books/form";
        }

        Book existingBook = bookService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));

        existingBook.setTitle(bookForm.getTitle());
        existingBook.setAuthor(bookForm.getAuthor());
        existingBook.setGenre(bookForm.getGenre());
        existingBook.setPages(bookForm.getPages());
        existingBook.setReadingStatus(bookForm.getReadingStatus());
        existingBook.setNotes(bookForm.getNotes());

        bookService.save(existingBook);

        redirectAttributes.addFlashAttribute("successMessage", "Book updated successfully!");
        return "redirect:/books/" + id;
    }

    // POST /books/{id}/delete - Delete a book
    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        bookService.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Book deleted successfully.");
        return "redirect:/books";
    }
}
