package ru.mipt.rea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class StudentDTO {

    private int studentId;
    private String name;
    private String email;
    private String password;
    private Timestamp birthDate;
    private int course;
    private String faculty;
    private int groupNumber;

    public StudentDTO (String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }
}
