package ru.mipt.rea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mipt.rea.service.UserServiceImpl;

@Controller
@RequestMapping("home/admin/**")
public class AdminHomeController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public String AdminHomePage() {
        return "admin_home";
    }
}