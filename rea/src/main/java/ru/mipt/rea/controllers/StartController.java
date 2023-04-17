package ru.mipt.rea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping("/")
    public String redirectToStart() {
        return "redirect:/start";
    }

    @GetMapping("/start")
    public String start() {
        return "start";
    }
}
