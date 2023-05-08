package ru.mipt.rea.models;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Report {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private int mark;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

}
