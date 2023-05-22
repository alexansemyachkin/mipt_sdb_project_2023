package ru.mipt.rea.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mipt.rea.dto.SubjectDTO;
import ru.mipt.rea.dto.TicketDTO;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.models.Subject;
import ru.mipt.rea.service.SubjectService;
import ru.mipt.rea.service.TicketService;
import ru.mipt.rea.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final UserServiceImpl userService;

    private final SubjectService subjectService;

    private final TicketService ticketService;


    @ModelAttribute("subject")
    public SubjectDTO subjectDTO() {
        return new SubjectDTO();
    }

    @ModelAttribute("ticket")
    public TicketDTO ticketDTO() {
        return new TicketDTO();
    }

    @ModelAttribute("examiner")
    public UserDTO userDTO() {return new UserDTO();}


    @GetMapping
    public String AdminHomePage(Model model) {
        List<SubjectDTO> subjectList = subjectService.findAll();
        model.addAttribute("subject_list", subjectList);
        return "admin_home";
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

    @PostMapping("/add_examiner")
    public String addExaminer(@ModelAttribute("examiner") UserDTO userDTO) {
        userService.register(userDTO, "ROLE_EXAMINER");
        return "redirect:/admin";
    }
}