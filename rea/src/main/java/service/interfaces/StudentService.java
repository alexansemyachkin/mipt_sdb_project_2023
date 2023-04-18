package service.interfaces;

import ru.mipt.rea.dto.StudentDTO;
import ru.mipt.rea.models.user.Student;

public interface StudentService {

    Student save(StudentDTO studentDTO);
    Student update(StudentDTO studentDTO);
    Student findByEmail(String email);
}
