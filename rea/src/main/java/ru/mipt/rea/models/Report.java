package ru.mipt.rea.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Report {

    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private int mark;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

}
