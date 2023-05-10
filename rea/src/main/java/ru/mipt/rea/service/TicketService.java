package ru.mipt.rea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.TicketDTO;
import ru.mipt.rea.models.Ticket;
import ru.mipt.rea.repos.TicketRepo;

import java.util.List;

@Service
public class TicketService {


        @Autowired
        private TicketRepo ticketRepo;


        public Ticket save(TicketDTO TicketDTO){
            Ticket Ticket = new Ticket(TicketDTO.getQuestion(), TicketDTO.getSubject());
            return ticketRepo.save(Ticket);
        }


        public Ticket findTicketById(int id) {
            return ticketRepo.findById(id);
        }


        public List<Ticket> findTicketBySubjectId(int id) {
            return ticketRepo.findBySubjectId(id);
        }


        public List<Ticket> findAll() {
            return ticketRepo.findAll();
        }

}
