package ru.mipt.rea.dto;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Course must not be blank")
    private int course;

    @NotBlank(message = "Faculty must not be blank")
    private String faculty;

    @NotBlank(message = "Group must not be blank")
    private int groupNumber;

    public StudentDTO(String email, String password) {
        super(email, password);
    }
}
