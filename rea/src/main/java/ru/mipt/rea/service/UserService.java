package ru.mipt.rea.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.models.User;

public interface UserService extends UserDetailsService {

    void register(UserDTO dto, String roleName);

    void save(UserDTO dto);

    UserDTO findByEmail(String email);

    UserDTO findById(int id);

    UserDetails loadUserByUsername(String username);


}
