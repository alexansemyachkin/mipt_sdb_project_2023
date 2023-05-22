package ru.mipt.rea.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mipt.rea.dto.ReportDTO;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.service.ReportService;
import ru.mipt.rea.service.TicketService;
import ru.mipt.rea.service.UserServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("examiner/approve/{subject_id}")
@AllArgsConstructor
public class ApproveExamController {

    private final ReportService reportService;

    private final UserServiceImpl userService;

    @ModelAttribute
    public void getReport(@PathVariable("subject_id") int subjectId, Model model) {
        ReportDTO report = reportService.getExamReport(subjectId);
        model.addAttribute("report", report);
    }

    @GetMapping
    public String approveSolution() {
        return "examiner_approve";
    }

    @PostMapping
    public String submitComment(@ModelAttribute("report") ReportDTO report, Model model, HttpSession httpSession) {
        int examinerId = (Integer) httpSession.getAttribute("userId");
        UserDTO examiner = userService.findById(examinerId);
        report.setExaminer(examiner);
        reportService.save(report);
        return "redirect:/examiner";
    }

}
