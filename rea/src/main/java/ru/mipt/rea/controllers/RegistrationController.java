package ru.mipt.rea.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.exception.UserAlreadyExistsException;
import ru.mipt.rea.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {

    private final AuthenticationProvider authenticationProvider;

    private final UserServiceImpl userService;


    @ModelAttribute("user")
    public UserDTO userDTO() {
        return new UserDTO();
    }

    @GetMapping String registrationForm() {
        return "registration";
    }

    @PostMapping
    public String registration(@ModelAttribute("user") @Valid UserDTO userDTO,
                               BindingResult bindingResult,
                               Model model,
                               HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "registration";
        }
        try {
            userService.register(userDTO, "ROLE_STUDENT");
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword());
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = authenticationProvider.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/student";
        } catch (UserAlreadyExistsException exception) {
            bindingResult.rejectValue("email", "error.user", "Пользователь с таким логином уже существует");
            return "registration";
        }
    }

}
