package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.models.user.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

    public Student findByEmail(String email);
}
