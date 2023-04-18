package ru.mipt.rea.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.mipt.rea.models.other.Role;

public interface UserService<T, V> extends UserDetailsService {

    T save(V dto);
    T update(V dto);
    T register(V dto);

    UserDetails loadUserByUsername(String username);

    T findByEmail(String email);

}
