package ru.mipt.rea.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ticket {

    @Id
    @Column(nullable = false)
    private int ticketId;

    @Column(nullable = false)
    private String question;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;

}
