package ru.mipt.rea.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Exam {

    @Id
    @Column(nullable = false)
    private int examId;

    @Column(nullable = false)
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;

    @OneToMany(mappedBy = "exam")
    private List<Report> reportList;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "examId"), inverseJoinColumns = @JoinColumn(name = "examinerId"))
    private List<Examiner> examinerList;

    @ManyToMany
    @JoinTable(name = "studen_exam", joinColumns = @JoinColumn(name = "examId"), inverseJoinColumns = @JoinColumn(name = "studentId"))
    private List<Student> studentList;

}
