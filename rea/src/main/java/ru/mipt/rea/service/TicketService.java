package ru.mipt.rea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.TicketDTO;
import ru.mipt.rea.models.Ticket;
import ru.mipt.rea.repos.TicketRepo;

import java.util.List;
import java.util.Random;

@Service
public class TicketService {


        @Autowired
        private TicketRepo ticketRepo;


        public void save(TicketDTO TicketDTO){
            Ticket Ticket = new Ticket(TicketDTO.getQuestion(), TicketDTO.getSubject());
            ticketRepo.save(Ticket);
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

        public Ticket getExamTicket(int subjectId) {
            List<Ticket> allTickets = ticketRepo.findBySubjectId(subjectId);
            int minInd = 0;
            int maxInd = allTickets.size() - 1;

            Random random = new Random();
            int ticketInd = random.nextInt(maxInd - minInd + 1) + minInd;
            return allTickets.get(ticketInd);
        }

}
