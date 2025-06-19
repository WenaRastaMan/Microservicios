package com.example.microservicio.de.administracion.membresia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plan")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Plan {
    @Id
    @Column(nullable = false)
    private Long idPlan;

    @Column(nullable = false)
    private String nombrePlan;

    
}
