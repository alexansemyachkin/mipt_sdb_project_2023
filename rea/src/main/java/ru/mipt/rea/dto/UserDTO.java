package ru.mipt.rea.dto;

import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mipt.rea.models.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Invalid email address")
    private String email;

    @Size(min = 8, max = 30, message = "Password must be between {min} and {max} characters")
    private String password;

    private Role role;

    public UserDTO(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }


}
