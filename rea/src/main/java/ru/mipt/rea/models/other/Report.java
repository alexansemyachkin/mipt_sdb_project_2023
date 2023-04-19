package ru.mipt.rea.models.other;

import jakarta.persistence.*;
import lombok.Data;
import ru.mipt.rea.models.user.Student;

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
    private Student student;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

}
