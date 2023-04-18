package ru.mipt.rea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToStart() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String start() {
        return "home";
    }
}
