package com.example.amassando_la_economia.controller;

import com.example.amassando_la_economia.dto.CotizacionDto;
import com.example.amassando_la_economia.dto.EstadisticosMonedaDto;
import com.example.amassando_la_economia.model.Cotizacion;
import com.example.amassando_la_economia.model.PlazoFijo;
import com.example.amassando_la_economia.repository.PlazoFijoRepository;
import com.example.amassando_la_economia.service.IPlazoFijoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/plazos")
public class PlazoFijoController {
    @Autowired
    private IPlazoFijoService plazoFijoService;

    @Operation(summary = "Obtienes datos actualizados o por fecha de todas los plazos fijos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get todas las cotizaciones (las mas recientes)"+
                    "Get todas las cotizaciones del dia"+"Get cotizaciones entre dos fechas",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cotizacion.class))}),
            @ApiResponse(responseCode = "404", description = "Error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cotizacion.class))})
    })
    @GetMapping(path = "/fijos/{fechaDesde}/hasta/{fechaHasta}")
    public List<PlazoFijo> obtenerPlazoPorFecha(
            @PathVariable("fechaDesde")String fechaDesde,
            @PathVariable("fechaHasta")String fechaHasta) {
        return this.plazoFijoService.getBetweenFechas(fechaDesde, fechaHasta);
    }

    @Operation(summary = "Obtienes valor actualizado de una plazo por su banco")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get por moneda y cotizacion (el mas reciente)",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cotizacion.class))}),
            @ApiResponse(responseCode = "404", description = "Error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cotizacion.class))})
    })
    @GetMapping(path = "/fijos/{banco}")
    public PlazoFijo obtenerUltimoPlazoBanco(
            @PathVariable("banco")String banco) {
        return this.plazoFijoService.getByBanco(banco);
    }
/*
    TODO: Pensar que estadisticos necesita la app
    @Operation(summary = "Obtienes datos estadisticos de un plazo por su banco")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ")",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cotizacion.class))}),
            @ApiResponse(responseCode = "404", description = "Error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cotizacion.class))})
    })
    @GetMapping(path = "/estadisticos/plazo/{banco}")
    public EstadisticosMonedaDto obtenerEstadisticosPlazo(
            @PathVariable("banco")String banco) {
        return this.cotizacionService.obtenerEstadisticos(banco);
    }

 */
}
