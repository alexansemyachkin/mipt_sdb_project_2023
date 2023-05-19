package ru.mipt.rea.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.models.Report;
import ru.mipt.rea.repos.ReportRepo;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class ReportService {

    private final ReportRepo reportRepo;

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


    public ReportDTO getExamReport(int subjectId) {
        List<ReportDTO> allReports = findBySubjectIdAndMarkEquals(subjectId, 0);
        int minInd = 0;
        int maxInd = allReports.size() - 1;

        Random random = new Random();
        int reportId = random.nextInt(maxInd - minInd + 1) + minInd;
        return allReports.get(reportId);
    }

    public void save(ReportDTO reportDTO) {
        Report report = covertToEntity(reportDTO);
        reportRepo.save(report);
    }

    public double averageScore(int studentId) {
        List<Integer> markList = reportRepo.findByStudentId(studentId).stream()
                .map(Report::getMark)
                .toList();

        return markList.parallelStream()
                .mapToDouble(Integer::doubleValue)
                .filter(mark -> mark > 0)
                .average()
                .orElse(0.0);
    }



}
