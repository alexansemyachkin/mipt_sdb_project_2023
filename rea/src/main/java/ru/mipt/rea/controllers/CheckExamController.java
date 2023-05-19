package ru.mipt.rea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.models.Report;
import ru.mipt.rea.models.User;
import ru.mipt.rea.service.ReportService;
import ru.mipt.rea.service.SubjectService;
import ru.mipt.rea.service.TicketService;
import ru.mipt.rea.service.UserServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
@RequestMapping("examiner/{subject_id}_check")
public class CheckExamController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ReportService reportService;

    @ModelAttribute("student_object")
    public UserDTO student() {
        return new UserDTO();
    }

    @GetMapping
    public String check(@PathVariable("subject_id") int subjectId, Model model) {
       List<User> studentList = reportService.findStudentsBySubjectId(subjectId);
       model.addAttribute("student_list", studentList);
       model.addAttribute("subject_id", subjectId);
       return "check";
    }

    @PostMapping
    public String pick(@ModelAttribute("student_object") UserDTO student, Model model) {
        System.out.println(student.getId());
        Report report = reportService.findByStudentId(student.getId());
        model.addAttribute("report", report);
        return "redirect:/examiner/{subject_id}_check/approve";
    }

    @GetMapping("/approve")
    public String review(@ModelAttribute("report") Report report, HttpSession httpSession) {
        int examiner_id = (Integer) httpSession.getAttribute("userId");
        report.setExaminer(userService.findById(examiner_id));
        return "check";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute("report") ReportDTO reportDTO, HttpSession httpSession) {
        reportService.update(reportDTO);
        return "redirect:/home/examiner";
    }

}
