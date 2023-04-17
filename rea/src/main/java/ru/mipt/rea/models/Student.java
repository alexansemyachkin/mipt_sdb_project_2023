package ru.mipt.rea.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @Column(nullable = false)
    private int studentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Timestamp birthDate;

    @Column(nullable = false)
    private int course;

    @Column(nullable = false)
    private String faculty;

    @Column(nullable = false)
    private int groupNumber;

    @OneToMany(mappedBy = "student")
    private List<Report> reportList;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "studentId"), inverseJoinColumns = @JoinColumn(name = "examId"))
    private List<Exam> examList;

}
