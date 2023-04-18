package ru.mipt.rea.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Student extends User {

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


    public Student (int userId, String name, String email, String password, Timestamp birthDate,
                    int course, String faculty, int groupNumber) {
        this.setUserId(userId);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setBirthDate(birthDate);
        this.setCourse(course);
        this.setFaculty(faculty);
        this.setGroupNumber(groupNumber);
    }
    public Student (String name, String email, String password, Timestamp birthDate,
                    int course, String faculty, int groupNumber) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setBirthDate(birthDate);
        this.setCourse(course);
        this.setFaculty(faculty);
        this.setGroupNumber(groupNumber);
    }

    public Student() {}
}
