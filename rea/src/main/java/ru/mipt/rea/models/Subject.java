package ru.mipt.rea.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Subject {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String department;

    @OneToMany(mappedBy = "subject")
    private List<Exam> examList;

    @OneToMany(mappedBy = "subject")
    private List<Ticket> ticketList;

}
