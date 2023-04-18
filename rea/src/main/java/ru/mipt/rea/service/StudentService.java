package ru.mipt.rea.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.StudentDTO;
import ru.mipt.rea.exception.UserAlreadyExistsException;
import ru.mipt.rea.models.other.Role;
import ru.mipt.rea.models.user.Student;
import ru.mipt.rea.repos.StudentRepo;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService implements UserService<Student, StudentDTO>{

    private final BCryptPasswordEncoder passwordEncoder;

    private final StudentRepo studentRepo;

    public Student save(StudentDTO studentDTO) {
        Student student = new Student(
                studentDTO.getName(),
                studentDTO.getEmail(),
                passwordEncoder.encode(studentDTO.getPassword()),
                studentDTO.getBirthDate(),
                studentDTO.getCourse(),
                studentDTO.getFaculty(),
                studentDTO.getGroupNumber()
        );
        return studentRepo.save(student);
    }

    public Student update(StudentDTO studentDTO) {
        Student student = new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getEmail(),
                passwordEncoder.encode(studentDTO.getPassword()),
                studentDTO.getBirthDate(),
                studentDTO.getCourse(),
                studentDTO.getFaculty(),
                studentDTO.getGroupNumber()
        );
        return studentRepo.save(student);
    }

    public Student register(StudentDTO studentDTO) {
        Student student = findByEmail(studentDTO.getEmail());
        if (student != null) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }
        return save(studentDTO);
    }

    public Student findByEmail(String email) {
        return studentRepo.findByEmail(email);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepo.findByEmail(username);
        if (student == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(student.getEmail(), student.getPassword(), Collections.singleton(mapRolesToAuthorities(student.getRole())));
    }

    private SimpleGrantedAuthority mapRolesToAuthorities(Role role){
        return new SimpleGrantedAuthority(role.getName());
    }
}
