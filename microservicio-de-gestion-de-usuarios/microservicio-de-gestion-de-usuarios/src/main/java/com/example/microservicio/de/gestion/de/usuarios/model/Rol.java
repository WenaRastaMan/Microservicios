package com.example.microservicio.de.gestion.de.usuarios.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(nullable = false)
    private String nombreRol;

    @Column(nullable = false)
    private String descripcionRol;

    @Column(nullable = false)
    private String permisosRol;

    @OneToMany(mappedBy = "rol")
    @JoinColumn(name = "usuario_id")
    @Column(nullable = true)
    private List<Usuario> usuarios;

    @ManyToMany
    @JoinTable(name = "rol_privilegio", joinColumns = @JoinColumn(name = "rol_id"), inverseJoinColumns = @JoinColumn(name = "privilegio_id"))
    private List<Privilegio> privilegios;

}
