package com.library.controller;

import com.library.exception.LibraryException;
import com.library.model.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        try {
            userService.registerUser(user);
            redirectAttributes.addFlashAttribute("success", "Регистрация успешно завершена");
            return "redirect:/login";
        } catch (LibraryException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/users/register";
        }
    }

    @GetMapping("/profile")
    public String showProfile(@RequestParam String phoneNumber, Model model) {
        try {
            userService.findByPhoneNumber(phoneNumber)
                    .ifPresent(user -> model.addAttribute("user", user));
            return "profile";
        } catch (LibraryException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            userService.findById(id).ifPresent(user -> model.addAttribute("user", user));
            return "edit-user";
        } catch (LibraryException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        try {
            userService.update(user);
            redirectAttributes.addFlashAttribute("success", "Профиль успешно обновлен");
            return "redirect:/users/profile?phoneNumber=" + user.getPhoneNumber();
        } catch (LibraryException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/users/edit/" + user.getUserId();
        }
    }

    @GetMapping("/library/add/{bookId}")
    public String addBookToLibrary(@PathVariable Long bookId, 
                                 @AuthenticationPrincipal UserDetails userDetails,
                                 RedirectAttributes redirectAttributes) {
        try {
            User user = userService.findByPhoneNumber(userDetails.getUsername())
                .orElseThrow(() -> new LibraryException("Пользователь не найден"));
            userService.addBookToLibrary(user.getUserId(), bookId);
            redirectAttributes.addFlashAttribute("success", "Книга добавлена в прочитанные");
        } catch (LibraryException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/books";
    }

    @GetMapping("/library/remove/{bookId}")
    public String removeBookFromLibrary(@PathVariable Long bookId,
                                      @AuthenticationPrincipal UserDetails userDetails,
                                      RedirectAttributes redirectAttributes) {
        try {
            User user = userService.findByPhoneNumber(userDetails.getUsername())
                .orElseThrow(() -> new LibraryException("Пользователь не найден"));
            userService.removeBookFromLibrary(user.getUserId(), bookId);
            redirectAttributes.addFlashAttribute("success", "Книга удалена из прочитанных");
        } catch (LibraryException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/users/profile?phoneNumber=" + userDetails.getUsername();
    }
} 