package ru.mipt.rea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mipt.rea.models.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int id;

    @NotBlank(message = "Имя не должно быть пустым")
    @Size(min = 3, max = 30, message = "Длина имени должна быть между {min} и {max} символами")
    private String name;

    @Email(message = "Электронная почта недействительна", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotBlank(message = "Электронная поста не должна быть пустой")
    private String email;

    @NotBlank(message = "Пароль не должен быть пустым")
    @Size(min = 8, max = 30, message = "Длина пароля должна быть между {min} и {max} символами")
    private String password;

    private Role role;

}
