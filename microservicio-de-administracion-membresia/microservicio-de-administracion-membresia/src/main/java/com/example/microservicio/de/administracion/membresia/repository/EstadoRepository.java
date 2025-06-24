package com.example.microservicio.de.administracion.membresia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicio.de.administracion.membresia.model.Estado;

@Repository

public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
    

