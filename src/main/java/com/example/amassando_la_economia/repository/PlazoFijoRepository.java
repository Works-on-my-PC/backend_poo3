package com.example.amassando_la_economia.repository;

import com.example.amassando_la_economia.model.PlazoFijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface PlazoFijoRepository extends JpaRepository<PlazoFijo, Integer> {
    @Transactional
    @Query(value = "SELECT * FROM plazos_fijos AS pf WHERE pf.banco = ?1",
            nativeQuery = true)
    PlazoFijo getByBanco(String banco);

    @Transactional
    @Query(value = "SELECT * FROM plazos_fijos AS pf WHERE pf.fecha_de_registro BETWEEN ?1 AND ?2",
            nativeQuery = true)
    List<PlazoFijo> getBetweenFechas(Date fechaDesde, Date fechaHasta);
}
