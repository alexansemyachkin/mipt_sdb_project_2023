package ru.mipt.rea.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.mipt.rea.dto.StudentDTO;
import ru.mipt.rea.exception.UserAlreadyExistsException;
import ru.mipt.rea.service.StudentService;

import javax.naming.Binding;

@Controller
@RequestMapping("home/student/registration")
public class StudentRegistrationController {

    private StudentService studentService;


    @ModelAttribute("student")
    public StudentDTO studentDTO() {
        return new StudentDTO();
    }

    @GetMapping
    public String studentRegistrationView() {
        return "student_registration";
    }

    @PostMapping
    public String studentRegistration(@Valid @ModelAttribute("student") StudentDTO studentDTO,
                                      BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student_registration";
        }
        try {
            studentService.registrate(studentDTO);
        } catch (UserAlreadyExistsException exception) {
            model.addAttribute("studentDTo", studentDTO);
            return "redirect:/student_registration";
        }
        redirectAttributes.addAttribute("id", studentDTO.getId());
        return "redirect:/home/student/{id}";
    }
}
