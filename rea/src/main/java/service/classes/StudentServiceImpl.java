package service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.StudentDTO;
import ru.mipt.rea.exception.UserAlreadyExistsException;
import ru.mipt.rea.models.Student;
import ru.mipt.rea.repos.StudentRepo;
import service.interfaces.StudentService;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

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


    @Override
    public Student update(StudentDTO studentDTO) {
        Student student = new Student(
                studentDTO.getStudentId(),
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

    @Override
    public Student findByEmail(String email) {
        return studentRepo.findByEmail(email);
    }
}
