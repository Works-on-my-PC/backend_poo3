package com.example.amassando_la_economia.service;

import com.example.amassando_la_economia.dto.CotizacionDto;
import com.example.amassando_la_economia.dto.CotizacionFechaDto;

import java.util.List;

public interface ICotizacionService {
    //List<Cotizacion> findAll();

    List<CotizacionFechaDto> obtenerMondedasPorFecha(String fechaDesde, String fechaHasta);

    CotizacionDto obtenerUltimaCotizacion(String codMoneda, String cotizacion);

    //EstadisticosMonedaDto obtenerEstadisticos(String moneda);
}
