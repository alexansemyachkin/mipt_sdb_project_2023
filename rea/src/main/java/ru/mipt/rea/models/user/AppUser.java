package ru.mipt.rea.models.user;

import jakarta.persistence.*;
import lombok.Data;
import ru.mipt.rea.models.other.Role;

import java.sql.Timestamp;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class AppUser {

    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
