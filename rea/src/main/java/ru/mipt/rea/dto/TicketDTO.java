package ru.mipt.rea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mipt.rea.models.Subject;
import ru.mipt.rea.models.Ticket;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    private int id;

    private String question;

    private Subject subject;

    public TicketDTO(String question, Subject subject) {
        this.question = question;
        this.subject = subject;
    }


}
