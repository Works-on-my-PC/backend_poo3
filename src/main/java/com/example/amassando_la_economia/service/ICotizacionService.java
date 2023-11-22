package com.example.amassando_la_economia.service;

import com.example.amassando_la_economia.dto.CotizacionDto;
import com.example.amassando_la_economia.dto.CotizacionFechaDto;
import com.example.amassando_la_economia.dto.EstadisticosMonedaDto;
import com.example.amassando_la_economia.model.Cotizacion;

import java.util.List;

public interface ICotizacionService {
    //List<Cotizacion> findAll();

    List<CotizacionFechaDto> obtenerMondedasPorFecha(String fechaDesde, String fechaHasta);

    CotizacionDto obtenerUltimaCotizacion(String moneda, String cotizacion);

    //EstadisticosMonedaDto obtenerEstadisticos(String moneda);
}
