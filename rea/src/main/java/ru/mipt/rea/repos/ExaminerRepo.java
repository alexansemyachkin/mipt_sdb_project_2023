package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.models.user.Examiner;

@Repository
public interface ExaminerRepo extends CrudRepository<Examiner, Integer>{

    public Examiner findByEmail(String email);
}
