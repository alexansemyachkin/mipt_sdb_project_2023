package ru.mipt.rea.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mipt.rea.service.UserServiceImpl;

@Controller
@RequestMapping("home/examiner/**")
public class ExaminerHomeController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping
    public String ExaminerHomePage() {
        return "examiner_home_page";
    }
}
