package ru.mipt.rea.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.models.Report;
import ru.mipt.rea.models.Role;

import java.util.List;

@Repository
public interface ReportRepo extends CrudRepository<Report, Integer> {

    Report findById(int id);

    Report findByStudentIdAndSubjectId(int studentId, int subjectId);



}
