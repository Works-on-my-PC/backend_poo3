package com.example.amassando_la_economia.service.implementation;

import com.example.amassando_la_economia.dto.CotizacionDto;
import com.example.amassando_la_economia.dto.EstadisticosMonedaDto;
import com.example.amassando_la_economia.model.Cotizacion;
import com.example.amassando_la_economia.repository.CotizacionRepository;
import com.example.amassando_la_economia.service.ICotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CotizacionService implements ICotizacionService {
    @Autowired
    private CotizacionRepository repository;

    public List<Cotizacion> findAll() {
        return  this.repository.findAll();
    }

    @Override
    public List<CotizacionDto> obtenerMondedasPorFecha(String fechaDesde, String fechaHasta) {
        ArrayList<CotizacionDto>temp = new ArrayList<>();
        temp.add(new CotizacionDto((long)1,fechaDesde,fechaHasta,"test"));
        temp.add(new CotizacionDto((long)2,fechaDesde,fechaHasta,"test2"));
        return temp;
    }

    @Override
    public CotizacionDto obtenerUltimaMondedaNombre(String moneda) {
        return new CotizacionDto((long)2,"fechaDesde","fechaHasta",moneda);
    }

    @Override
    public EstadisticosMonedaDto obtenerEstadisticos(String moneda) {
        return new EstadisticosMonedaDto(moneda,"0 promedio");

    }
}
