package ru.mipt.rea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.exception.UserAlreadyExistsException;
import ru.mipt.rea.models.User;
import ru.mipt.rea.service.UserServiceImpl;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AuthenticationProvider authenticationProvider;


    @GetMapping String registrationForm() {
        return "registration";
    }

    @PostMapping
    public String registration(@ModelAttribute("user") UserDTO userDTO,
                               RedirectAttributes redirectAttributes,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "registration";
        }

        try {
            User user = userService.register(userDTO);
            redirectAttributes.addAttribute("id", userDTO.getId());
            redirectAttributes.addFlashAttribute("message", "Registration successful");
            return "redirect:/home/student/{id}";

        } catch (UserAlreadyExistsException exception) {
            bindingResult.rejectValue("username", "error.user", "User with this username already exists");
            return "registration";
        }
    }
}
