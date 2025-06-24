package com.example.microservicio.de.pago.y.facturaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicio.de.pago.y.facturaciones.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    

}
