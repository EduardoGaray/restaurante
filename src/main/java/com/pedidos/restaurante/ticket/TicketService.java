package com.pedidos.restaurante.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired private TicketRepository repo;

    public List<Ticket> listAll(){
        return (List<Ticket>) repo.findAll();
    }

    public void save(Ticket ticket) {

        repo.save(ticket);
    }

    public Ticket get(Integer id) throws TicketNotFoundException {
        Optional<Ticket> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new TicketNotFoundException("No se ha encontrado el Ticket solicitado");
    }
}
