package ru.mipt.rea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int id;
    private String name;
    private String email;
    private String password;
    Timestamp birthDate;

    public UserDTO(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }
}
