package com.example.microservicio.de.administracion.membresia.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlan;

    @Column(nullable = false)
    private String nombrePlan;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double costo;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<Incluido> incluidos;

}
