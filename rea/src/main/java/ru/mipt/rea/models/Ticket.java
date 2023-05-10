package ru.mipt.rea.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
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

    public Ticket(String question, Subject subject) {
        this.question = question;
        this.subject = subject;
    }

}
