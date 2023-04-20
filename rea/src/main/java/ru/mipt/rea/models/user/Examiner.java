package ru.mipt.rea.models.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.mipt.rea.models.other.Exam;
import ru.mipt.rea.models.other.Role;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Examiner extends User {

    private String department;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "examiner_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<Exam> examList;

    public Examiner(String name, String email, String password, Role role) {
        super(name, email, password, role);
    }

    public Examiner(String name, String email, String password, String department) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setDepartment(department);
    }

    public Examiner(int id, String name, String email, String password, String department) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setDepartment(department);
    }


}
