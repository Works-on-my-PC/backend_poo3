package com.example.amassando_la_economia.service;

import com.example.amassando_la_economia.dto.CotizacionDto;
import com.example.amassando_la_economia.dto.EstadisticosMonedaDto;
import com.example.amassando_la_economia.model.Cotizacion;

import java.util.List;

public interface ICotizacionService {
    List<Cotizacion> findAll();

    List<CotizacionDto> obtenerMondedasPorFecha(String fechaDesde, String fechaHasta);

    CotizacionDto obtenerUltimaMondedaNombre(String moneda);

    EstadisticosMonedaDto obtenerEstadisticos(String moneda);
}
