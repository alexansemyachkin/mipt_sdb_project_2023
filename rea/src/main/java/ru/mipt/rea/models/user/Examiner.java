package ru.mipt.rea.models.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.mipt.rea.models.other.Exam;

import java.sql.Timestamp;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Examiner extends AppUser {

    @Column (nullable = false)
    private String department;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "examiner_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<Exam> examList;

    public Examiner(String name, String email, String password, Timestamp birthDate,
                     String department) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setBirthDate(birthDate);
        this.setDepartment(department);
    }

    public Examiner(int id, String name, String email, String password, Timestamp birthDate,
                    String department) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setBirthDate(birthDate);
        this.setDepartment(department);
    }


}
