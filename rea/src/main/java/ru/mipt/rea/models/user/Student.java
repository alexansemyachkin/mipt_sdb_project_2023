package ru.mipt.rea.models.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.mipt.rea.models.other.Exam;
import ru.mipt.rea.models.other.Report;
import ru.mipt.rea.models.other.Role;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Student extends User {

    private int course;

    private String faculty;

    private int groupNumber;

    @OneToMany(mappedBy = "student")
    private List<Report> reportList;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<Exam> examList;


    public Student (int id, String name, String email, String password, int course, String faculty, int groupNumber, Role role) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setCourse(course);
        this.setFaculty(faculty);
        this.setGroupNumber(groupNumber);
        this.setRole(role);
    }
    public Student (String name, String email, String password, int course, String faculty, int groupNumber, Role role) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setCourse(course);
        this.setFaculty(faculty);
        this.setGroupNumber(groupNumber);
        this.setRole(role);
    }
}
