package ru.mipt.rea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mipt.rea.models.Subject;
import ru.mipt.rea.models.User;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {


    private int id;

    private int mark;


    private User student;

    private User examiner;


    private Subject subject;

    private String ticketId;

    private String solution;

    private String comment;

    public ReportDTO(int mark, User student, User examiner, Subject subject, String ticketId, String solution, String comment) {
        this.mark = mark;
        this.student = student;
        this.examiner = examiner;
        this.subject = subject;
        this.ticketId = ticketId;
        this.solution = solution;
        this.comment = comment;
    }

}
