package com.pedidos.restaurante;

import org.springframework.web.bind.annotation.GetMapping;

public class ControladorPrincipal {
    @GetMapping("")
    public String showHomePage(){
        return "index";
    }

}
