package com.example.microservicio.de.administracion.membresia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "incluido")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Incluido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idIncluido;

    @ManyToOne
    @JoinColumn(name = "id_plan") // nombre de la columna FK en la tabla Incluido
    private Plan plan;
}
