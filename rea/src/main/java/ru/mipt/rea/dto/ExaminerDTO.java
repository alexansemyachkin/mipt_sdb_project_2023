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
public class ExaminerDTO extends UserDTO{


    @NotBlank(message = "Department must not be blank")
    private String department;

    public ExaminerDTO(String email, String password) {
        super(email, password);
    }
}
