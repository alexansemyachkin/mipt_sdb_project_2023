package ru.mipt.rea.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.dto.SubjectDTO;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.exception.UserAlreadyExistsException;
import ru.mipt.rea.models.Role;
import ru.mipt.rea.models.User;
import ru.mipt.rea.repos.RoleRepo;
import ru.mipt.rea.repos.UserRepo;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private BCryptPasswordEncoder passwordEncoder;

    private final UserRepo userRepo;

    private final SubjectService subjectService;

    private final TicketService ticketService;

    private final ReportService reportService;

    private final RoleRepo roleRepo;

    private final Convertor convertor;

    public User convertToEntity(UserDTO userDTO) {
        return convertor.convert(userDTO, User.class);
    }

    public UserDTO convertToDto(User user) {
        return convertor.convert(user, UserDTO.class);
    }

    public void register(UserDTO userDTO) {
        userDTO.setRole(roleRepo.findRoleByName("ROLE_STUDENT"));
        UserDTO existingUser = findByEmail(userDTO.getEmail());
        if (existingUser != null) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }
        save(userDTO);
    }

    public void save(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        String password = userDTO.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepo.save(user);
    }

    public UserDTO findByEmail(String email) {
        User user = userRepo.findByEmail(email);
        return convertToDto(user);
    }

    public UserDTO findById(int id) {
        User user = userRepo.findById(id);
        return convertToDto(user);
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

    public List<SubjectDTO> getStudentSubjects(int studentId) {
        List<SubjectDTO> subjectList = subjectService.findAll();
        List<ReportDTO> reportList = reportService.findByStudentId(studentId);
        subjectList.removeIf(subject -> ticketService.findTicketBySubjectId(subject.getId()).isEmpty());

    }

}
