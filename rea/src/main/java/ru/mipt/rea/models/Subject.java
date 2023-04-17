package ru.mipt.rea.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Subject {

    @Id
    @Column(nullable = false)
    private int subjectId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String department;

    @OneToMany(mappedBy = "subject")
    private List<Exam> examList;

    @OneToMany(mappedBy = "subject")
    private List<Ticket> ticketList;

}
