package ru.mipt.rea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mipt.rea.service.UserServiceImpl;

@Controller
@RequestMapping("/home/student")
@SessionAttributes("userId")
public class StudentHomeController {


    @Autowired
    private UserServiceImpl userService;


    @ModelAttribute("userId")
    public Integer userId() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findByEmail(email).getId();
    }

    @GetMapping
    public String StudentHomePage(@ModelAttribute("userId") Integer userId) {
        return "redirect:/home/student/" + userId;
    }

    @GetMapping("/{id}")
    public String ExactStudentHomePage(@PathVariable String id) {
        return "student_home";
    }
}
