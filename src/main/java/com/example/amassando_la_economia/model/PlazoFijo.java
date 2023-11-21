package com.example.amassando_la_economia.model;

import com.example.amassando_la_economia.model.plazo_fijo_types.Tipo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "plazos_fijos")
@Getter @Setter
public class PlazoFijo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private BigDecimal tna;

    private BigDecimal tea;

    private String banco;

    @Column(name = "fecha_de_registro")
    private Date fechaDeRegistro;
}
