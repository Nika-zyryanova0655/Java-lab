package com.library.controller;

import com.library.exception.LibraryException;
import com.library.model.Genre;
import com.library.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/genres")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public String listGenres(Model model) {
        model.addAttribute("genres", genreService.findAll());
        return "genres";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "add-genre";
    }

    @PostMapping("/add")
    public String addGenre(@ModelAttribute Genre genre, RedirectAttributes redirectAttributes) {
        try {
            genreService.save(genre);
            redirectAttributes.addFlashAttribute("success", "Жанр успешно добавлен");
            return "redirect:/genres";
        } catch (LibraryException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/genres/add";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            genreService.findById(id).ifPresent(genre -> model.addAttribute("genre", genre));
            return "edit-genre";
        } catch (LibraryException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/edit")
    public String updateGenre(@ModelAttribute Genre genre, RedirectAttributes redirectAttributes) {
        try {
            genreService.update(genre);
            redirectAttributes.addFlashAttribute("success", "Жанр успешно обновлен");
            return "redirect:/genres";
        } catch (LibraryException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/genres/edit/" + genre.getGenreId();
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteGenre(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            genreService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Жанр успешно удален");
        } catch (LibraryException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/genres";
    }
} 