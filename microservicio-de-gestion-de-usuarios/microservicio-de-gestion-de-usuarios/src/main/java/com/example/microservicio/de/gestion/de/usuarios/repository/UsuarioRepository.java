package com.example.microservicio.de.gestion.de.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicio.de.gestion.de.usuarios.model.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCorreoUsuario(String correoUsuario);

    boolean existsByTelefonoUsuario(String telefonoUsuario);

    boolean existsByNombreUsuarioAndApellidoUsuario(String nombreUsuario, String apellidoUsuario);
}
