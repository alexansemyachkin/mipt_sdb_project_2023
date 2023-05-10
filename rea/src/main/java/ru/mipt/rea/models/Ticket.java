package ru.mipt.rea.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String question;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

}
