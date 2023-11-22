package com.example.amassando_la_economia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class CotizacionFechaDto {
    private String codMoneda;
    private String cotizacion;
    private BigDecimal valorEnPesos;
    private Date fechaDeRegistro;

    public CotizacionFechaDto(){}

}