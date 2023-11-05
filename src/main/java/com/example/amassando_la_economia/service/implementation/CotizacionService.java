package com.example.amassando_la_economia.service.implementation;

import com.example.amassando_la_economia.model.Cotizacion;
import com.example.amassando_la_economia.repository.CotizacionRepository;
import com.example.amassando_la_economia.service.ICotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotizacionService implements ICotizacionService {
    @Autowired
    private CotizacionRepository repository;

    @Override
    public List<Cotizacion> getAll() {
        return repository.findAll();
    }
}
