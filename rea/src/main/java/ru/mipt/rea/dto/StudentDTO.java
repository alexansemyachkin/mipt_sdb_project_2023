package ru.mipt.rea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO extends UserDTO{

    private int course;
    private String faculty;
    private int groupNumber;

    public StudentDTO(String email, String password) {
        super(email, password);
    }
}
