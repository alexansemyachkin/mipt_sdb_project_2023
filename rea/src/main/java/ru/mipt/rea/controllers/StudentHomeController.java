package ru.mipt.rea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.mipt.rea.service.UserServiceImpl;

@Controller
@RequestMapping("home/student/**")
@SessionAttributes("user")
public class StudentHomeController {


    @Autowired
    private UserServiceImpl userService;


    @GetMapping
    public String StudentHomePage() {
        return "student_home";
    }
}
