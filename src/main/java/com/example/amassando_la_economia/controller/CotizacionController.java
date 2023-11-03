package com.example.amassando_la_economia.controller;

import com.example.amassando_la_economia.model.Cotizacion;
import com.example.amassando_la_economia.service.ICotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cotizaciones")
public class CotizacionController {

    @Autowired
    private ICotizacionService service;

    //TODO: Revisar por que no trae nada de la BD
    @GetMapping("/find")
    public List<Cotizacion> getAll() {
        return service.findAll();
    }
}
