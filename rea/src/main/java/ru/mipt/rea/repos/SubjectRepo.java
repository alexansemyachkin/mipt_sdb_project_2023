package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.models.Subject;

import java.util.List;

@Repository
public interface SubjectRepo extends CrudRepository<Subject, Integer> {

    Subject findById(int id);
    Subject findByName(String name);

    List<Subject> findAll();

}
