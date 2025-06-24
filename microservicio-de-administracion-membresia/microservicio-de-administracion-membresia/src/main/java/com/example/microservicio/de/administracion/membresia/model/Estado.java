package com.example.microservicio.de.administracion.membresia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estado")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Estado {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idEstado;

    @Column (nullable = false, unique = true)
    private String nombre;

    
}
