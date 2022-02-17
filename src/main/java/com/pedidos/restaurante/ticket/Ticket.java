package com.pedidos.restaurante.ticket;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Time;

@Entity
@Table(name =  "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 2)
    private Integer mesa;

    @Column(length = 25, nullable = false)
    private String nombre;
    @Column(length = 3, nullable = false)
    private Integer idcamarero;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(nullable = false)
    private Time hora;
    @Column(nullable = false)
    private String notas;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdcamarero() {
        return idcamarero;
    }

    public void setIdcamarero(Integer idcamarero) {
        this.idcamarero = idcamarero;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public  Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
