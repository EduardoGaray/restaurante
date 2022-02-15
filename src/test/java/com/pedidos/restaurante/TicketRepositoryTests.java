package com.pedidos.restaurante;

import com.pedidos.restaurante.ticket.Ticket;
import com.pedidos.restaurante.ticket.TicketRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.PortUnreachableException;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TicketRepositoryTests {
    @Autowired private TicketRepository repo;

    @Test
    public void testAddNew(){
        Ticket ticket = new Ticket();
        ticket.setMesa(8);
        ticket.setCantidad(1);
        ticket.setHora(8.25);
        ticket.setIdcamarero(345);
        ticket.setNombre("vurger mediana");
        ticket.setNotas("sin lechuga");

        Ticket savedTicket = repo.save(ticket);

//        Assertions.assertThat(savedTicket).isNotNull();
//        Assertions.assertThat(savedTicket.getId()).isGreaterThan(0);
    }

    @Test
    public void testlistAll(){
        Iterable<Ticket> tickets = repo.findAll();
        //Assertions.assertThat(ticket).hasSizeGreaterThan(0);
        for (Ticket ticket : tickets){
            System.out.println(ticket);
        }
    }

    @Test
    public void testUpdate(){
        Integer ticketId = 1;
        Optional<Ticket> optionalTicket = repo.findById(ticketId);
        repo.findById(ticketId);
        Ticket ticket = optionalTicket.get();
        ticket.setCantidad(52);
        repo.save(ticket);

        Ticket updatedTicket = repo.findById(ticketId).get();
    }

    @Test
    public void testGet(){
        Integer ticketId = 1;
        Optional<Ticket> optionalTicket = repo.findById(ticketId);
        System.out.println(optionalTicket.get());

    }

    @Test
    public void testDelete(){
        Integer ticketId = 1;
        repo.deleteById(ticketId);
        Optional<Ticket> optionalTicket = repo.findById(ticketId);
    }
}
