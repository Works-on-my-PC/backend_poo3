package com.example.amassando_la_economia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "cotizaciones")
@Getter @Setter
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cod_moneda")
    private String codMoneda;
    private String cotizacion;
    @Column(name = "valor_en_ars")
    private BigDecimal valorEnArs;
    @Column(name = "fecha_de_registro")
    private Date fechaDeRegistro;
}
