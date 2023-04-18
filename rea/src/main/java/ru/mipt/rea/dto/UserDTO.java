package ru.mipt.rea.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserDTO {

    private int id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Invalid email address")
    private String email;

    @Size(min = 8, max = 30, message = "Password must be between {min} and {max} characters")
    private String password;

    public UserDTO(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }
}
