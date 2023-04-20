package ru.mipt.rea.models.other;

import jakarta.persistence.*;
import lombok.Data;
import ru.mipt.rea.models.user.User;

import java.util.List;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> AppUserList;
}
