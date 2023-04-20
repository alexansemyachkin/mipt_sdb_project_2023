package ru.mipt.rea.controllers.registration;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import ru.mipt.rea.models.user.Student;
import ru.mipt.rea.service.StudentServiceImpl;

@Controller
@RequestMapping("home/student/registration")
public class StudentRegistrationController {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @GetMapping
    public String registrationForm(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "registration";
    }

    @PostMapping
    public String registration(@ModelAttribute("student") StudentDTO studentDTO,
                               RedirectAttributes redirectAttributes,
                               BindingResult bindingResult,
                               Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "registration";
        }

        try {
            Student student = studentService.register(studentDTO);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(student.getEmail(), student.getPassword());
            Authentication authentication = authenticationProvider.authenticate(authenticationToken);
            redirectAttributes.addAttribute("id", studentDTO.getId());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            redirectAttributes.addFlashAttribute("message", "Registration successful");
            return "redirect:/home/student/{id}";

        } catch (UserAlreadyExistsException exception) {
            bindingResult.rejectValue("username", "error.user", "User with this username already exists");
            return "registration";
        }
    }
}
