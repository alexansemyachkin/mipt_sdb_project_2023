package ru.mipt.rea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mipt.rea.models.Subject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    private int id;

    private String question;

    private SubjectDTO subject;

}
