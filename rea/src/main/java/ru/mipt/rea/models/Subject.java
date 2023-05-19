package ru.mipt.rea.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "subject")
    private List<Ticket> ticketList;

    @OneToMany(mappedBy = "subject")
    private List<Report> reportList;

}
