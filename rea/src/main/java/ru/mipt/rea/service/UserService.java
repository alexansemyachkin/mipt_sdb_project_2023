package ru.mipt.rea.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService<T, V> extends UserDetailsService {

    T save(V dto);
    T update(V dto);
    T register(V dto);

    T findByEmail(String email);

}
