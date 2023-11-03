package com.example.amassando_la_economia.repository;

import com.example.amassando_la_economia.model.Cotizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotizacionRepository extends JpaRepository<Cotizacion, Long> {
}
