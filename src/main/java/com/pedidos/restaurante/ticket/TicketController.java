package com.pedidos.restaurante.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TicketController {
    @Autowired private TicketService service;

    @GetMapping("/ticket")
    public String showTicketList(Model model){
        List<Ticket> listTicket = service.listAll();
        model.addAttribute("listTicket", listTicket);
         return "ticket";
    }

    @GetMapping("/ticket/nuevo")
    public String showNewForm(Model model){
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("pageTitle", "Nuevo Ticket");
        return "ticket_form";
    }

    @PostMapping("/ticket/guardar")
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket){
        service.save(ticket);
        return "redirect:/ticket";
    }

    @GetMapping("/ticket/editar/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
           Ticket ticket = service.get(id);
           model.addAttribute("ticket", ticket);
            model.addAttribute("pageTitle", "Editar Ticket");
            return "ticket_form";
        } catch (TicketNotFoundException e) {
            ra.addFlashAttribute("message", "Ticket añadido.");
            return "redirect:/ticket";
        }
    }
}
