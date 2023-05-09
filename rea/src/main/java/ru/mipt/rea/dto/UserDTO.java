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

    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotBlank(message = "Email must not be blank")
    private String email;


    private String password;

    private Role role;

    public UserDTO(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }


}
