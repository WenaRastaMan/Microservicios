package com.example.microservicio.de.gestion.de.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicio.de.gestion.de.usuarios.model.Rol;

@Repository

public interface RolRepository extends JpaRepository<Rol, Long> {
    boolean existsByNombreRol(String nombreRol);

    boolean existsByDescripcionRol(String descripcionRol);

    boolean existsByPermisosRol(String permisosRol);

}
