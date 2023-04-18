package ru.mipt.rea.models.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mipt.rea.models.other.Exam;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Examiner extends AppUser {

    @Column (nullable = false)
    private String department;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "examiner_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<Exam> examList;

}
