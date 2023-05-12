package ru.mipt.rea.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.dto.SubjectDTO;
import ru.mipt.rea.models.Report;
import ru.mipt.rea.models.Subject;
import ru.mipt.rea.repos.ReportRepo;
import ru.mipt.rea.repos.SubjectRepo;

import java.util.List;

public class ReportService {

    @Autowired
    private ReportRepo reportRepo;


    public Report findById(int id) {
        return reportRepo.findById(id);
    }


}
