package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.models.Report;

import java.util.List;

@Repository
public interface ReportRepo extends CrudRepository<Report, Integer> {

    Report findById(int id);

    List<Report> findBySubjectIdAndMarkEquals(int id, int mark);
    Report findByStudentIdAndSubjectId(int studentId, int subjectId);

    List<Report> findByStudentId(int id);


}
