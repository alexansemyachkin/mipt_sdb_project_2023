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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
@SessionAttributes("userId")
@AllArgsConstructor
public class StudentController {


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
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        int studentId = userService.findByEmail(email).getId();
        List<SubjectDTO> subjects = subjectService.getStudentSubjects(studentId);
        model.addAttribute("subjects", subjects);
    }

    @GetMapping
    public String StudentHomePage(@ModelAttribute("userId") int userId,  Model model) {
        UserDTO user = userService.findById(userId);
        model.addAttribute("user", user);
        return "student_home";
    }

}
