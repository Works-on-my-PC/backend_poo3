package com.example.amassando_la_economia.service.implementation;

import com.example.amassando_la_economia.dto.CotizacionDto;
import com.example.amassando_la_economia.dto.CotizacionFechaDto;
import com.example.amassando_la_economia.dto.EstadisticosMonedaDto;
import com.example.amassando_la_economia.mapper.CotizacionMapper;
import com.example.amassando_la_economia.model.Cotizacion;
import com.example.amassando_la_economia.repository.CotizacionRepository;
import com.example.amassando_la_economia.service.ICotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CotizacionService implements ICotizacionService {
    @Autowired
    private CotizacionRepository repository;


    @Override
    public List<CotizacionFechaDto> obtenerMondedasPorFecha(String fechaDesde, String fechaHasta) {
        ArrayList<CotizacionFechaDto> cotFechaDtoAList = new ArrayList<>();
        List<Cotizacion> cotList = this.repository.findByfechaDeRegistroBetween(Date.valueOf(fechaDesde), Date.valueOf(fechaHasta));
        for (Cotizacion cot :
                cotList) {
            cotFechaDtoAList.add(CotizacionMapper.cotizacionToCotizacionFechaDto(cot));
        }
        return cotFechaDtoAList;
    }

    @Override
    public CotizacionDto obtenerUltimaCotizacion(String codMoneda, String cotizacion) {
        Cotizacion cot = this.repository.findTopByCodMonedaAndCotizacionOrderByFechaDeRegistroDesc(codMoneda, cotizacion);
        return CotizacionMapper.cotizacionToCotizacionDto(cot);
    }

    /*
    @Override
    public EstadisticosMonedaDto obtenerEstadisticos(String moneda) {
        return new EstadisticosMonedaDto(moneda,"0 promedio");

    } */
}
