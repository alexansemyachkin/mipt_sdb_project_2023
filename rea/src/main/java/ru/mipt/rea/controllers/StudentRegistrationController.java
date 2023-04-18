package ru.mipt.rea.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.mipt.rea.dto.ExaminerDTO;
import ru.mipt.rea.dto.StudentDTO;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.exception.UserAlreadyExistsException;
import ru.mipt.rea.service.ExaminerService;
import ru.mipt.rea.service.StudentService;
import ru.mipt.rea.service.UserService;

@Controller
@RequestMapping("/registration")
public class StudentRegistrationController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExaminerService examinerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping
    public String registrationForm(Model model) {
        model.addAttribute("student", new StudentDTO());
        model.addAttribute("examiner", new ExaminerDTO());
        return "registration";
    }

    @PostMapping
    public String registration(@Valid @ModelAttribute("student") StudentDTO studentDTO, BindingResult studentBindingResult,
                                      @Valid @ModelAttribute("examiner") ExaminerDTO examinerDTO, BindingResult examinerBindingResult,
                                      Model model, RedirectAttributes redirectAttributes,
                                      HttpServletRequest request) {
        if (request.getParameter("studentForm") != null) {
            return processingForm(studentDTO, "student", studentBindingResult, redirectAttributes, model);
        } else {
            return processingForm(examinerDTO, "examiner", examinerBindingResult, redirectAttributes, model);
        }
    }

    public String processingForm(UserDTO userDTO, String type, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "registration";
        }

        UserService userService;
        if (userDTO.getClass() == StudentDTO.class) {
            userService = studentService;
        } else if (userDTO.getClass() == ExaminerDTO.class) {
            userService = examinerService;
        } else {
            throw new IllegalArgumentException("Invalid user type");
        }

        try {
            userService.register(userDTO);
        } catch (UserAlreadyExistsException exception) {
            model.addAttribute("type", userDTO);
            return "registration";
        }
        redirectAttributes.addAttribute("id", userDTO.getId());
        return "redirect:/succeed";
    }
}
