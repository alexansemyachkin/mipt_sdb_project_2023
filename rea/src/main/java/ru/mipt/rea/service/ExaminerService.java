package ru.mipt.rea.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.ExaminerDTO;
import ru.mipt.rea.exception.UserAlreadyExistsException;
import ru.mipt.rea.models.other.Role;
import ru.mipt.rea.models.user.Examiner;
import ru.mipt.rea.repos.ExaminerRepo;

import java.util.Collections;

@Service
@AllArgsConstructor
public class ExaminerService implements UserService<Examiner, ExaminerDTO>{

    private final BCryptPasswordEncoder passwordEncoder;
    private final ExaminerRepo examinerRepo;

    public Examiner save(ExaminerDTO examinerDTO) {
        Examiner examiner = new Examiner(
                examinerDTO.getName(),
                examinerDTO.getEmail(),
                passwordEncoder.encode(examinerDTO.getPassword()),
                examinerDTO.getDepartment()
        );
        return examinerRepo.save(examiner);
    }

    public Examiner update(ExaminerDTO examinerDTO) {
        Examiner examiner = new Examiner(
                examinerDTO.getId(),
                examinerDTO.getName(),
                examinerDTO.getEmail(),
                passwordEncoder.encode(examinerDTO.getPassword()),
                examinerDTO.getDepartment()
        );
        return examinerRepo.save(examiner);
    }

    public Examiner findByEmail(String email) {
        return examinerRepo.findByEmail(email);
    }

    public Examiner register(ExaminerDTO examinerDTO) {
        Examiner examiner = findByEmail(examinerDTO.getEmail());
        if (examiner != null) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }
        return save(examinerDTO);
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Examiner examiner = examinerRepo.findByEmail(email);
        if (examiner == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(examiner.getEmail(), examiner.getPassword(),
                Collections.singleton(mapRolesToAuthorities(examiner.getRole())));
    }

    private SimpleGrantedAuthority mapRolesToAuthorities(Role role){
        return new SimpleGrantedAuthority(role.getName());
    }
}
