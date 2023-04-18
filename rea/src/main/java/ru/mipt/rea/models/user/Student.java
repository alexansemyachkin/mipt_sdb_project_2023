package ru.mipt.rea.models.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.mipt.rea.models.other.Exam;
import ru.mipt.rea.models.other.Report;

import java.sql.Timestamp;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Student extends AppUser {

    @Column(nullable = false)
    private int course;

    @Column(nullable = false)
    private String faculty;

    @Column(nullable = false)
    private int groupNumber;

    @OneToMany(mappedBy = "student")
    private List<Report> reportList;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<Exam> examList;


    public Student (int id, String name, String email, String password, Timestamp birthDate,
                    int course, String faculty, int groupNumber) {
        this.setId(id);
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
}
