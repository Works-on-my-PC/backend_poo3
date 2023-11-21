package com.example.amassando_la_economia.service.implementation;

import com.example.amassando_la_economia.model.PlazoFijo;
import com.example.amassando_la_economia.repository.PlazoFijoRepository;
import com.example.amassando_la_economia.service.IPlazoFijoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PlazoFijoService implements IPlazoFijoService {
    @Autowired
    private PlazoFijoRepository repository;

    public PlazoFijo getByBanco(String banco) {
        return this.repository.getByBanco(banco);
    }

    public List<PlazoFijo> getBetweenFechas(String fechaDesde, String fechaHasta) {
        return this.repository.getBetweenFechas(Date.valueOf(fechaDesde), Date.valueOf(fechaHasta));
    }
}
