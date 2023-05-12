package ru.mipt.rea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.models.Report;
import ru.mipt.rea.repos.ReportRepo;

@Service
public class ReportService {

    @Autowired
    private ReportRepo reportRepo;

    public Report findById(int id) {
        return reportRepo.findById(id);
    }

    public Report save(ReportDTO reportDTO) {
        Report report = new Report(reportDTO.getStudent(),
                                   reportDTO.getSubject(),
                                   reportDTO.getTicket(),
                                   reportDTO.getSolution());
        return reportRepo.save(report);
    }


}
