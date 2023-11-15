package com.example.amassando_la_economia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
@AllArgsConstructor
public class EstadisticosMonedaDto {
    private String moneda;
    private String promedio;

    public EstadisticosMonedaDto(){}

  

}