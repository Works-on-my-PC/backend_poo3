/*APIs:



Get plazos fijos por banco (el mas reciente)
Get plazos fijos entre fechas
Get porcentaje de variacion plazos fijos*/
package com.example.amassando_la_economia.controller;

import com.example.amassando_la_economia.dto.CotizacionDto;
import com.example.amassando_la_economia.dto.CotizacionFechaDto;
import com.example.amassando_la_economia.model.Cotizacion;
import com.example.amassando_la_economia.service.ICotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api/cotizaciones")
public class CotizacionController {

    @Autowired
    private ICotizacionService cotizacionService;

    @Operation(summary = "Obtienes datos actualizados o por fecha de todas las monedas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get todas las cotizaciones (las mas recientes)"+
                    "Get todas las cotizaciones del dia"+"Get cotizaciones entre dos fechas",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cotizacion.class))}),
            @ApiResponse(responseCode = "404", description = "Error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cotizacion.class))})
    })
    @GetMapping(path = "/monedas/{fechaDesde}/hasta/{fechaHasta}")
    public List<CotizacionFechaDto> obtenerMonedasEntreDosFechas(
            @PathVariable("fechaDesde")String fechaDesde,
            @PathVariable("fechaHasta")String fechaHasta) {
        return this.cotizacionService.obtenerMondedasPorFecha(fechaDesde,fechaHasta);
    }



    @Operation(summary = "Obtienes valor actualizado de una moneda por su nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get por moneda y cotizacion (el mas reciente)",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cotizacion.class))}),
            @ApiResponse(responseCode = "404", description = "Error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cotizacion.class))})
    })
    @GetMapping(path = "/moneda/{moneda}/cotizacion/{cotizacion}")
    public CotizacionDto obtenerUltimaCotizacion(
            @PathVariable("moneda")String moneda,
            @PathVariable("cotizacion")String cotizacion){
        return this.cotizacionService.obtenerUltimaCotizacion(moneda, cotizacion);
    }


    /*
    @Operation(summary = "Obtienes datos estadisticos de una moneda por su nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ")",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cotizacion.class))}),
            @ApiResponse(responseCode = "404", description = "Error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cotizacion.class))})
    })
    @GetMapping(path = "/estadisticos/moneda/{moneda}")
    public EstadisticosMonedaDto obtenerEstaditicosMoneda(
            @PathVariable("moneda")String moneda) {
        return this.cotizacionService.obtenerEstadisticos(moneda);
    }
    */
}
