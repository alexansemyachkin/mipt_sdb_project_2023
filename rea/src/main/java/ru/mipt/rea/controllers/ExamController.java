package ru.mipt.rea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.models.Subject;
import ru.mipt.rea.models.Ticket;
import ru.mipt.rea.models.User;
import ru.mipt.rea.service.SubjectService;
import ru.mipt.rea.service.TicketService;
import ru.mipt.rea.service.UserServiceImpl;

@Controller
@RequestMapping("home/{subject}_exam")
public class ExamController {


    @Autowired
    private TicketService ticketService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UserServiceImpl userService;

    @ModelAttribute
    public void tickets(@ModelAttribute("userId") int userId, @PathVariable("subject") String subject, Model model) {
        User student = userService.findById(userId);
        Subject subjectObject = subjectService.findByName(subject);
        Ticket ticket = ticketService.getExamTicket(subjectObject.getId());

        ReportDTO reportDTO = new ReportDTO(student, subjectObject, ticket);

        model.addAttribute("exam", reportDTO);

    }


    @GetMapping
    public String exam() {
        return "exam";
    }

    @PostMapping
    public String submit(@ModelAttribute) {

    }
}
