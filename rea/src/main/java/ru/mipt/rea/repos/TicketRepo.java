package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.models.Ticket;

import java.util.List;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Integer> {

    Ticket findById(int id);

    List<Ticket> findBySubjectId(int id);

    List<Ticket> findAll();

}
