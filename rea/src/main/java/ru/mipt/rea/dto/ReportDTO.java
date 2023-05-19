package ru.mipt.rea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {


    private int id;

    private int mark;


    private UserDTO student;

    private UserDTO examiner;

    private SubjectDTO subject;

    private TicketDTO ticket;

    private String solution;

    private String comment;

    public ReportDTO(int mark, UserDTO student, UserDTO examiner, SubjectDTO subject,
                     TicketDTO ticket, String solution, String comment) {
        this.mark = mark;
        this.student = student;
        this.examiner = examiner;
        this.subject = subject;
        this.ticket = ticket;
        this.solution = solution;
        this.comment = comment;
    }

    public ReportDTO(UserDTO student, SubjectDTO subject, TicketDTO ticket) {
        this.student = student;
        this.subject = subject;
        this.ticket = ticket;
    }

}
