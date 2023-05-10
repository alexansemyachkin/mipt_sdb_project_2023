package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.models.Ticket;

import java.util.List;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Integer> {

    public List<Ticket> findBySubjectId(int id);

    public Ticket findById(int id);

    public List<Ticket> findAll();

}
