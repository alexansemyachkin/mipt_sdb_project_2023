package ru.mipt.rea.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Exam {

    @Id
    @Column(nullable = false)
    private int examId;

    @Column(nullable = false)
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name="subjectId")
    private Subject subject;




}
