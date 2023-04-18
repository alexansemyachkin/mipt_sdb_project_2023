package service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.StudentDTO;
import ru.mipt.rea.exception.UserAlreadyExistsException;
import ru.mipt.rea.models.user.Student;
import ru.mipt.rea.repos.StudentRepo;

@Service
@AllArgsConstructor
public class StudentService implements UserService {


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

    public Student registrate(StudentDTO studentDTO) {
        Student student = findByEmail(studentDTO.getEmail());
        if (student != null) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }
        return save(studentDTO);
    }

    public Student findByEmail(String email) {
        return studentRepo.findByEmail(email);
    }
}
