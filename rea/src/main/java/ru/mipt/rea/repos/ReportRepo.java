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

    List<Report> findByMarkEquals(int mark);

    List<Report> findByStudentId(int id);

}
