package ru.mipt.rea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.models.Subject;
import ru.mipt.rea.models.Ticket;
import ru.mipt.rea.models.User;
import ru.mipt.rea.service.ReportService;
import ru.mipt.rea.service.SubjectService;
import ru.mipt.rea.service.TicketService;
import ru.mipt.rea.service.UserServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("home/{subject_id}_exam")
public class ExamController {


    @Autowired
    private TicketService ticketService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ReportService reportService;

    @ModelAttribute
    public void tickets(HttpSession session, @PathVariable("subject_id") int subjectId, Model model) {
        int userId = (Integer) session.getAttribute("userId");
        User student = userService.findById(userId);
        Subject subjectObject = subjectService.findById(subjectId);
        Ticket ticket = ticketService.getExamTicket(subjectObject.getId());

        ReportDTO reportDTO = new ReportDTO(student, subjectObject, ticket);

        model.addAttribute("exam", reportDTO);

    }


    @GetMapping
    public String exam(@ModelAttribute("exam") ReportDTO reportDTO) {
        return "exam";
    }

    @PostMapping
    public String submit(@ModelAttribute("exam") ReportDTO reportDTO) {
        reportService.save(reportDTO);
        return "redirect:/home";
    }
}
