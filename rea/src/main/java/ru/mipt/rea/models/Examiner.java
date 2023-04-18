package ru.mipt.rea.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Examiner extends AppUser {

    @Column (nullable = false)
    private String department;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "examiner_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<Exam> examList;

}
