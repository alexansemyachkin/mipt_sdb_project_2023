package ru.mipt.rea.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.exception.UserAlreadyExistsException;
import ru.mipt.rea.models.other.Role;
import ru.mipt.rea.models.user.User;
import ru.mipt.rea.repos.UserRepo;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final UserRepo userRepo;

    public User register(UserDTO userDTO) {
        User user = findByEmail(userDTO.getEmail());
        if (user != null) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }
        return save(userDTO);
    }

    public User save(UserDTO userDTO) {
        User user = new User(userDTO.getName(),
                             userDTO.getEmail(),
                             passwordEncoder.encode(userDTO.getPassword()),
                             userDTO.getRole());
        return userRepo.save(user);
    }

    public User update(UserDTO userDTO) {
        User user = new User(userDTO.getId(),
                             userDTO.getName(),
                             userDTO.getEmail(),
                             passwordEncoder.encode(userDTO.getPassword()),
                             userDTO.getRole());
        return userRepo.save(user);
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                                                                      user.getPassword(),
                                                                      Collections.singleton(mapRolesToAuthorities(user.getRole())));
    }

    private SimpleGrantedAuthority mapRolesToAuthorities(Role role){
        return new SimpleGrantedAuthority(role.getName());
    }

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


}
