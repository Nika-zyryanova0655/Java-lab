package com.library.controller;

import com.library.exception.LibraryException;
import com.library.model.Book;
import com.library.model.User;
import com.library.service.BookService;
import com.library.service.GenreService;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final GenreService genreService;
    private final UserService userService;

    @Autowired
    public BookController(BookService bookService, GenreService genreService, UserService userService) {
        this.bookService = bookService;
        this.genreService = genreService;
        this.userService = userService;
    }

    @GetMapping
    public String listBooks(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("books", bookService.findAll());
        
        if (userDetails != null) {
            userService.findByPhoneNumber(userDetails.getUsername())
                    .ifPresent(user -> model.addAttribute("user", user));
        }
        
        return "books";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("genres", genreService.findAll());
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        try {
            bookService.save(book);
            redirectAttributes.addFlashAttribute("success", "Книга успешно добавлена");
            return "redirect:/books";
        } catch (LibraryException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/books/add";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            bookService.findById(id).ifPresent(book -> {
                model.addAttribute("book", book);
                model.addAttribute("genres", genreService.findAll());
            });
            return "edit-book";
        } catch (LibraryException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/edit")
    public String updateBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        try {
            bookService.update(book);
            redirectAttributes.addFlashAttribute("success", "Книга успешно обновлена");
            return "redirect:/books";
        } catch (LibraryException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/books/edit/" + book.getBookId();
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            bookService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Книга успешно удалена");
        } catch (LibraryException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/books";
    }
} 