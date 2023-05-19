package ru.mipt.rea.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    private int mark;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "examiner_id")
    private User examiner;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    private String solution;

    private String comment;

//    public Report(int mark, User student, User examiner, Subject subject, Ticket ticket, String solution, String comment) {
//        this.mark = mark;
//        this.student = student;
//        this.examiner = examiner;
//        this.subject = subject;
//        this.ticket = ticket;
//        this.solution = solution;
//        this.comment = comment;
//    }
//
//    public Report(User student, Subject subject, Ticket ticket, String solution) {
//        this.student = student;
//        this.subject = subject;
//        this.ticket = ticket;
//        this.solution = solution;
//    }
}
