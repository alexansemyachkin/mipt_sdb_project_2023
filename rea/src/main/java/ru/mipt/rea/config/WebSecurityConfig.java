package ru.mipt.rea.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import org.springframework.stereotype.Service;
import ru.mipt.rea.service.ExaminerService;
import ru.mipt.rea.service.StudentService;
import ru.mipt.rea.service.UserService;

import java.util.List;

@Configuration
public class WebSecurityConfig {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExaminerService examinerService;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(new BCryptPasswordEncoder());
        return auth;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider studentAuth = authenticationProvider(studentService);
        DaoAuthenticationProvider examinerAuth = authenticationProvider(examinerService);
        return new ProviderManager(List.of(studentAuth, examinerAuth));
    }


    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/", "/registration")
                .permitAll()
                .requestMatchers("/home/examiner/**").hasRole("ROLE_EXAMINER")
                .requestMatchers("/home/student/**").hasRole("ROLE_STUDENT")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/home", true)
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .permitAll();
    }
}