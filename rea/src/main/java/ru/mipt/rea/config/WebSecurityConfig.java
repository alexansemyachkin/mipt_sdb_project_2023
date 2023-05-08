package ru.mipt.rea.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.mipt.rea.repos.UserRepo;
import ru.mipt.rea.service.UserService;
import ru.mipt.rea.service.UserServiceImpl;

@Configuration
public class WebSecurityConfig {

    @Autowired
    UserService userService;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(new BCryptPasswordEncoder());
        return auth;
    }


    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/", "/registration", "/welcome")
                .permitAll()
                .requestMatchers("/home/examiner/**").hasRole("examiner")
                .requestMatchers("/home/student/**").hasRole("student")
                .requestMatchers("/home/admin/**").hasRole("admin")
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