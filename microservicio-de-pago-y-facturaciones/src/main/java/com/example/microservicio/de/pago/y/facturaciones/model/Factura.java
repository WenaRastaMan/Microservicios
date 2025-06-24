package com.example.microservicio.de.pago.y.facturaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Factura {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long membresiaId;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long pagoId;
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String estado;
}
