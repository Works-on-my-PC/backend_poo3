package com.example.amassando_la_economia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter 
@Setter
@AllArgsConstructor
public class CotizacionDto {
    private String codMoneda;
    private String cotizacion;
    private BigDecimal valorEnPesos;

    public CotizacionDto(){}

}

