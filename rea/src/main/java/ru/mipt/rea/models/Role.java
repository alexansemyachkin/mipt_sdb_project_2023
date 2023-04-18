package ru.mipt.rea.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Role {

    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "role")
    private List<AppUser> AppUserList;
}
