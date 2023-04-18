package ru.mipt.rea.models;

import jakarta.persistence.*;
import lombok.Data;

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

    @Column(nullable = false)
    private Timestamp birthDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
