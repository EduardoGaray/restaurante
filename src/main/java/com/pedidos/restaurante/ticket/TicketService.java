package com.pedidos.restaurante.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired private TicketRepository repo;

    public List<Ticket> listAll(){
        return (List<Ticket>) repo.findAll();
    }

}
