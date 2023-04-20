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
public class ExaminerServiceImpl extends UserServiceImpl{

    private final BCryptPasswordEncoder passwordEncoder;

    private final ExaminerRepo examinerRepo;

    public Examiner save(ExaminerDTO examinerDTO) {
        Examiner examiner = new Examiner(examinerDTO.getName(),
                                         examinerDTO.getEmail(),
                                         passwordEncoder.encode(examinerDTO.getPassword()),
                                         examinerDTO.getDepartment());
        return examinerRepo.save(examiner);
    }

    public Examiner update(ExaminerDTO examinerDTO) {
        Examiner examiner = new Examiner(examinerDTO.getId(),
                                         examinerDTO.getName(),
                                         examinerDTO.getEmail(),
                                         passwordEncoder.encode(examinerDTO.getPassword()),
                                         examinerDTO.getDepartment());
        return examinerRepo.save(examiner);
    }

}
