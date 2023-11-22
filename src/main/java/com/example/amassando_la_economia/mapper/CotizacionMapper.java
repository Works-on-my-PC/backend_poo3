package com.example.amassando_la_economia.mapper;

import com.example.amassando_la_economia.dto.CotizacionDto;
import com.example.amassando_la_economia.dto.CotizacionFechaDto;
import com.example.amassando_la_economia.model.Cotizacion;

public class CotizacionMapper {
    private CotizacionMapper() {}
    public static CotizacionDto cotizacionToCotizacionDto(Cotizacion cotizacion) {
        return new CotizacionDto(cotizacion.getCodMoneda(), cotizacion.getCotizacion(), cotizacion.getValorEnArs());
    }

    public static CotizacionFechaDto cotizacionToCotizacionFechaDto(Cotizacion cotizacion) {
        return new CotizacionFechaDto(cotizacion.getCodMoneda(), cotizacion.getCotizacion(), cotizacion.getValorEnArs(), cotizacion.getFechaDeRegistro());
    }
}
