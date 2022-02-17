package com.pedidos.restaurante.ticket;

public class TicketNotFoundException extends Throwable {
    public TicketNotFoundException(String message) {
        super(message);
    }
}
