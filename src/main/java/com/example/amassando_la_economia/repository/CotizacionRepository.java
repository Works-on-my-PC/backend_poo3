package com.example.amassando_la_economia.repository;

import com.example.amassando_la_economia.model.Cotizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CotizacionRepository extends JpaRepository<Cotizacion, Integer> {
    List<Cotizacion> findByfechaDeRegistroBetween(Date fechaDesde, Date fechaHasta);

    Cotizacion findTopByCodMonedaAndCotizacionOrderByFechaDeRegistroDesc(String codMoneda, String cotizacion);
}
