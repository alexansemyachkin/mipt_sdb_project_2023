package ru.mipt.rea.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.models.other.Role;
import ru.mipt.rea.models.user.User;

public interface UserService extends UserDetailsService {

    User register(UserDTO dto);

    User save(UserDTO dto);

    User update(UserDTO dto);

    User findByEmail(String email);

    UserDetails loadUserByUsername(String username);


}
