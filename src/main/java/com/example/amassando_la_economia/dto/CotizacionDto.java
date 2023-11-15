package com.example.amassando_la_economia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
@AllArgsConstructor
public class CotizacionDto {
    private Long id;
    private String fechaDesde;
    private String fechaHasta;
    private String payload;

    public CotizacionDto(){}

  

}

