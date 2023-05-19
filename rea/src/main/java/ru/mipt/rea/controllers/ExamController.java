package ru.mipt.rea.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.dto.SubjectDTO;
import ru.mipt.rea.dto.TicketDTO;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.service.ReportService;
import ru.mipt.rea.service.SubjectService;
import ru.mipt.rea.service.TicketService;
import ru.mipt.rea.service.UserServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/student/exam/{subject_id}")
@AllArgsConstructor
public class ExamController {


    private final TicketService ticketService;

    private final SubjectService subjectService;

    private final UserServiceImpl userService;

    private final ReportService reportService;

    @ModelAttribute
    public void exam(HttpSession session, @PathVariable("subject_id") int subjectId, Model model) {
        int userId = (Integer) session.getAttribute("userId");
        UserDTO student = userService.findById(userId);
        SubjectDTO subject = subjectService.findById(subjectId);
        TicketDTO ticket = ticketService.getExamTicket(subject.getId());

        ReportDTO reportDTO = new ReportDTO(student, subject, ticket);

        model.addAttribute("exam", reportDTO);

    }


    @GetMapping
    public String examProcess(@ModelAttribute("exam") ReportDTO reportDTO) {
        return "student_exam";
    }

    @PostMapping
    public String submit(@ModelAttribute("exam") ReportDTO reportDTO) {
        reportService.save(reportDTO);
        return "redirect:/student";
    }
}
