package ru.mipt.rea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ExaminerDTO {

    private int examinerId;
    private String name;
    private String email;
    private String password;
    private Timestamp birthDate;
    private String department;

    public ExaminerDTO(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }
}
