package ru.mipt.rea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mipt.rea.dto.SubjectDTO;
import ru.mipt.rea.dto.TicketDTO;
import ru.mipt.rea.models.Subject;
import ru.mipt.rea.service.SubjectService;
import ru.mipt.rea.service.TicketService;
import ru.mipt.rea.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TicketService ticketService;


    @ModelAttribute("subject")
    public SubjectDTO subjectDTO() {
        return new SubjectDTO();
    }

    @ModelAttribute("ticket")
    public TicketDTO ticketDTO() {
        return new TicketDTO();
    }


    @GetMapping
    public String AdminHomePage(Model model) {
        List<Subject> subjectList = subjectService.findAll();
        model.addAttribute("subject_list", subjectList);
        return "admin";
    }

    @PostMapping("/add_subject")
    public String addSubject(@ModelAttribute("subject") SubjectDTO subjectDTO) {
        subjectService.save(subjectDTO);
        return "redirect:/admin";
    }

    @PostMapping("/add_ticket")
    public String addTicket(@ModelAttribute("ticket") TicketDTO ticketDTO, @ModelAttribute("subject") SubjectDTO subjectDTO) {
        String subjectName = subjectDTO.getName();
        ticketDTO.setSubject(subjectService.findByName(subjectName));
        ticketService.save(ticketDTO);
        return "redirect:/admin";
    }
}