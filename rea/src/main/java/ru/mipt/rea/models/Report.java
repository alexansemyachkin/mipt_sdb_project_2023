package ru.mipt.rea.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Report {

    @Id
    @Column(nullable = false)
    private int reportId;

    @Column(nullable = false)
    private int mark;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "examID")
    private Exam exam;

}
