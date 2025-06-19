package com.example.microservicio.de.administracion.membresia.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membresia")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Membresia {
    @Id
    @GeneratedValue
    private Long idMembresia;
    
    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false)
    private Date fechaFin;

    @Column(nullable =  false)
    private Double total;

}
