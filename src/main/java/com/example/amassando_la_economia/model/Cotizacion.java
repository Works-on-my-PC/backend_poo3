package com.example.amassando_la_economia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cotizaciones")
@Getter @Setter
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codMoneda;
    private String cotizacion;
    private double valorEnArs;
    private Date fechaDeRegistro;
}
