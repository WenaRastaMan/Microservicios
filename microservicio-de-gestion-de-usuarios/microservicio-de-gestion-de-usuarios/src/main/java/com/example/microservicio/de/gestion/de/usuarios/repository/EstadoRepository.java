package com.example.microservicio.de.gestion.de.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservicio.de.gestion.de.usuarios.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>   {
    
}
