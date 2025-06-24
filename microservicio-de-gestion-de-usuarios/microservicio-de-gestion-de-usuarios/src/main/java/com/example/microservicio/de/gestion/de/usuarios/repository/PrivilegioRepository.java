package com.example.microservicio.de.gestion.de.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservicio.de.gestion.de.usuarios.model.Privilegio;

public interface PrivilegioRepository extends JpaRepository<Privilegio, Long> {
    boolean existsByNombrePrivilegio(String nombrePrivilegio);

    boolean existsByDescripcionPrivilegio(String descripcionPrivilegio);

    boolean existsByPermisosPrivilegio(String permisosPrivilegio);

}
