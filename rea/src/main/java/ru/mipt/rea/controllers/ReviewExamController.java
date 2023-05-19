package ru.mipt.rea.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.service.ReportService;
import ru.mipt.rea.service.UserServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("student/review/{subject_id}")
@AllArgsConstructor
public class ReviewExamController {

    private final UserServiceImpl userService;

    private final ReportService reportService;

    @ModelAttribute
    public void getReport(@PathVariable("subject_id") int subjectId, Model model) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        int studentId = userService.findByEmail(email).getId();
        ReportDTO report = reportService.findByStudentIdAndSubjectId(studentId, subjectId);
        model.addAttribute("report", report);
    }

    @GetMapping
    public String reviewSolution() {
        return "student_review";
    }

}