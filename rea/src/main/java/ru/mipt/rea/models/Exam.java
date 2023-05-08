package ru.mipt.rea.models;

import javax.persistence.*;
import lombok.Data;

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
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> examinerList;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> studentList;

}
