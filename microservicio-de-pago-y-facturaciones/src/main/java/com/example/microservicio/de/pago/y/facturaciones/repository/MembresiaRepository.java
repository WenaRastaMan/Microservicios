package com.example.microservicio.de.pago.y.facturaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicio.de.pago.y.facturaciones.model.Membresia;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Long> {
    

}
