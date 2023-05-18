package ru.mipt.rea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.models.Report;
import ru.mipt.rea.models.User;
import ru.mipt.rea.repos.ReportRepo;
import ru.mipt.rea.repos.UserRepo;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepo reportRepo;

    @Autowired
    private UserRepo userRepo;


    public Report findById(int id) {
        return reportRepo.findById(id);
    }

    public List<Report> findBySubjectIdAndMarkEquals(int id, int mark) {
        return reportRepo.findBySubjectIdAndMarkEquals(id, mark);
    }

    public Report findByStudentId(int id) {
        return reportRepo.findByStudentId(id);
    }



    public List<User> findStudentsBySubjectId(int id) {
        List<Report> reportList = findBySubjectIdAndMarkEquals(id, 0);
        return reportList.stream()
                .map(Report::getStudent)
                .map(user -> userRepo.findById(user.getId())) // преобразуем каждый объект User с помощью метода getUserById()
                .toList();
    }

    public Report save(ReportDTO reportDTO) {
        Report report = new Report(reportDTO.getStudent(),
                                   reportDTO.getSubject(),
                                   reportDTO.getTicket(),
                                   reportDTO.getSolution());
        return reportRepo.save(report);
    }

    public Report update(ReportDTO reportDTO) {
        Report report = new Report(reportDTO.getMark(),
                reportDTO.getStudent(),
                reportDTO.getExaminer(),
                reportDTO.getSubject(),
                reportDTO.getTicket(),
                reportDTO.getSolution(),
                reportDTO.getComment());
        return reportRepo.save(report);
    }

}
