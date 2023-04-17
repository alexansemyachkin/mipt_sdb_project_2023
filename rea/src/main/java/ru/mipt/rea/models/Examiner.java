package ru.mipt.rea.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Examiner {

    @Id
    @Column(nullable = false)
    private int examinerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Timestamp birthDate;

    @Column (nullable = false)
    private String department;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "examinerId"), inverseJoinColumns = @JoinColumn(name = "examId"))
    private List<Exam> examList;

}
