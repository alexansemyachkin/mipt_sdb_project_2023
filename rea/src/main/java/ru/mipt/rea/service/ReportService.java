package ru.mipt.rea.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.models.Report;
import ru.mipt.rea.models.User;
import ru.mipt.rea.repos.ReportRepo;
import ru.mipt.rea.repos.UserRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {

    private final ReportRepo reportRepo;

    private final UserRepo userRepo;

    private final Convertor convertor;


    private Report covertToEntity(ReportDTO reportDTO) {
        return convertor.convert(reportDTO, Report.class);
    }

    private ReportDTO convertToDto(Report report) {
        return convertor.convert(report, ReportDTO.class);
    }

    private List<ReportDTO> convertToDtoList(List<Report> reportList) {
        return convertor.convertList(reportList, ReportDTO.class);
    }

    public ReportDTO findById(int id) {
        Report report = reportRepo.findById(id);
        return convertToDto(report);
    }

    public List<ReportDTO> findBySubjectIdAndMarkEquals(int id, int mark) {
        List<Report> reportList = reportRepo.findBySubjectIdAndMarkEquals(id, mark);
        return convertToDtoList(reportList);
    }

    public ReportDTO findByStudentId(int id) {
        Report report = reportRepo.findByStudentId(id);
        return convertToDto(report);
    }


    public List<User> findStudentsBySubjectId(int id) {
        List<ReportDTO> reportList = findBySubjectIdAndMarkEquals(id, 0);
        return reportList.stream()
                .map(ReportDTO::getStudent)
                .map(user -> userRepo.findById(user.getId())) // преобразуем каждый объект User с помощью метода getUserById()
                .toList();
    }

    public void save(ReportDTO reportDTO) {
        Report report = covertToEntity(reportDTO);
        reportRepo.save(report);
    }



}
