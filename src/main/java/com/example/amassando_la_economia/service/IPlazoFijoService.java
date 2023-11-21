package com.example.amassando_la_economia.service;

import com.example.amassando_la_economia.model.PlazoFijo;

import java.util.List;
import java.util.Optional;

public interface IPlazoFijoService {
    PlazoFijo getByBanco(String banco);

    List<PlazoFijo> getBetweenFechas(String fechaDesde, String fechaHasta);
}
