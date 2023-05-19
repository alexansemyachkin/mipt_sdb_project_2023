package ru.mipt.rea.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.TicketDTO;
import ru.mipt.rea.models.Ticket;
import ru.mipt.rea.repos.TicketRepo;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepo ticketRepo;
    private final Convertor convertor;


    private Ticket convertToEntity(TicketDTO ticketDTO) {
        return convertor.convert(ticketDTO, Ticket.class);
    }

    private TicketDTO convertToDto(Ticket ticket) {
        return convertor.convert(ticket, TicketDTO.class);
    }

    private List<TicketDTO> convertToDtoList(List<Ticket> ticketList) {
        return convertor.convertList(ticketList, TicketDTO.class);
    }

    public void save(TicketDTO ticketDTO){
        Ticket ticket = convertToEntity(ticketDTO);
        ticketRepo.save(ticket);
    }


    public TicketDTO findTicketById(int id) {
        Ticket ticket = ticketRepo.findById(id);
        return convertor.convert(ticket, TicketDTO.class);
    }

    public List<TicketDTO> findTicketBySubjectId(int id) {
        List<Ticket> ticketList = ticketRepo.findBySubjectId(id);
        return convertToDtoList(ticketList);
    }


    public List<TicketDTO> findAll() {
        List<Ticket> ticketList = ticketRepo.findAll();
        return convertToDtoList(ticketList);
    }

    public TicketDTO getExamTicket(int subjectId) {
        List<TicketDTO> allTickets = findTicketBySubjectId(subjectId);
        int minInd = 0;
        int maxInd = allTickets.size() - 1;

        Random random = new Random();
        int ticketInd = random.nextInt(maxInd - minInd + 1) + minInd;
        return allTickets.get(ticketInd);
    }
}
