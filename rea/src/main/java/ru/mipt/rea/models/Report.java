package ru.mipt.rea.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
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

    private String ticketId;

    private String solution;

    private String comment;

    public Report(int mark, User student, User examiner, Subject subject, String ticketId, String solution, String comment) {
        this.mark = mark;
        this.student = student;
        this.examiner = examiner;
        this.subject = subject;
        this.ticketId = ticketId;
        this.solution = solution;
        this.comment = comment;
    }

}
