package ru.mipt.rea.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Report {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
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

    private String solution;

    private String comment;

}
