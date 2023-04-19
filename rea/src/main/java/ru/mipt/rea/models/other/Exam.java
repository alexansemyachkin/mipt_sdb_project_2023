package ru.mipt.rea.models.other;

import jakarta.persistence.*;
import lombok.Data;
import ru.mipt.rea.models.user.Examiner;
import ru.mipt.rea.models.user.Student;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Exam {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "exam")
    private List<Report> reportList;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "examiner_id"))
    private List<Examiner> examinerList;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> studentList;

}
