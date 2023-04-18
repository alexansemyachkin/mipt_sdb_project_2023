package ru.mipt.rea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ExaminerDTO extends UserDTO{

    private String department;

    public ExaminerDTO(String email, String password) {
        super(email, password);
    }
}
