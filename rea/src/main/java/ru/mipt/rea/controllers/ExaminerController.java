package ru.mipt.rea.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.mipt.rea.dto.SubjectDTO;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.service.SubjectService;
import ru.mipt.rea.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/examiner")
@SessionAttributes("userId")
@AllArgsConstructor
public class ExaminerController {

    private final UserServiceImpl userService;

    private final SubjectService subjectService;


    @ModelAttribute
    public void userId(Model model) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        int userId = userService.findByEmail(email).getId();
        model.addAttribute("userId", userId);
    }

    @ModelAttribute
    public void subjects(Model model) {
        List<SubjectDTO> subjects = subjectService.findSubjectsToApprove();
        model.addAttribute("subjects", subjects);
    }

    @GetMapping
    public String ExaminerHomePage(@ModelAttribute("userId") int userId,  Model model) {
        UserDTO user = userService.findById(userId);
        model.addAttribute("user", user);
        return "examiner_home";
    }

}
