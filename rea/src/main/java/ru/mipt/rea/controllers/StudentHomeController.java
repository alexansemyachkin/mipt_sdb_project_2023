package ru.mipt.rea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.mipt.rea.models.User;
import ru.mipt.rea.service.UserServiceImpl;

@Controller
@RequestMapping("/home")
@SessionAttributes("userId")
public class StudentHomeController {


    @Autowired
    private UserServiceImpl userService;


    @ModelAttribute
    public void userId(Model model) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        int userId = userService.findByEmail(email).getId();
        model.addAttribute("userId", userId);
    }

    @GetMapping
    public String StudentHomePage(@ModelAttribute("userId") int userId,  Model model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "home";
    }

}
