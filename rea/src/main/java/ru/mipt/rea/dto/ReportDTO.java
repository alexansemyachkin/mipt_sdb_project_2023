package ru.mipt.rea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mipt.rea.models.Subject;
import ru.mipt.rea.models.Ticket;
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

    private Ticket ticket;

    private String solution;

    private String comment;

    public ReportDTO(int mark, User student, User examiner, Subject subject,
                     Ticket ticket, String solution, String comment) {
        this.mark = mark;
        this.student = student;
        this.examiner = examiner;
        this.subject = subject;
        this.ticket = ticket;
        this.solution = solution;
        this.comment = comment;
    }

    public ReportDTO(User student, Subject subject, Ticket ticket) {
        this.student = student;
        this.subject = subject;
        this.ticket = ticket;
    }

}
