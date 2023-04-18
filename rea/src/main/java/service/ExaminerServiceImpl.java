package service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.ExaminerDTO;
import ru.mipt.rea.models.user.Examiner;

@Service
@AllArgsConstructor
public class ExaminerService {


    public Examiner save(ExaminerDTO examinerDTO) {

    }

    public Examiner update(ExaminerDTO examinerDTO) {
        return null;
    }

    public Examiner findByEmail(String email) {
        return null;
    }
}
