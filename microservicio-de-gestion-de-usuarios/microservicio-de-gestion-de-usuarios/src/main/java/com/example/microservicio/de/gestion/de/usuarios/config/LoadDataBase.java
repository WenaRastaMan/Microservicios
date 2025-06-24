package com.example.microservicio.de.gestion.de.usuarios.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.microservicio.de.gestion.de.usuarios.model.Estado;
import com.example.microservicio.de.gestion.de.usuarios.model.Privilegio;
import com.example.microservicio.de.gestion.de.usuarios.model.Rol;
import com.example.microservicio.de.gestion.de.usuarios.model.Usuario;
import com.example.microservicio.de.gestion.de.usuarios.repository.EstadoRepository;
import com.example.microservicio.de.gestion.de.usuarios.repository.PrivilegioRepository;
import com.example.microservicio.de.gestion.de.usuarios.repository.RolRepository;
import com.example.microservicio.de.gestion.de.usuarios.repository.UsuarioRepository;



@Configuration

public class LoadDataBase {
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PrivilegioRepository privilegioRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    CommandLineRunner initDatabase(
            RolRepository rolRepository,
            PrivilegioRepository privilegioRepository,
            EstadoRepository estadoRepository,
            UsuarioRepository usuarioRepository) {
        return args -> {
            // Crear estados
            Estado activo = new Estado(null, "ACTIVO", null);
            Estado inactivo = new Estado(null, "INACTIVO", null);
            estadoRepository.saveAll(List.of(activo, inactivo));

            // Crear privilegios
            Privilegio leer = new Privilegio(null, "READ_PRIVILEGE", null, null, null);
            Privilegio escribir = new Privilegio(null, "WRITE_PRIVILEGE", null, null, null);
            privilegioRepository.saveAll(List.of(leer, escribir));

            // Crear roles con privilegios
            Rol admin = new Rol(null, "ADMIN", null, null, null, null);
            admin.setPrivilegios(List.of(leer, escribir));
            Rol user = new Rol(null, "USER", null, null, null, null);
            user.setPrivilegios(List.of(leer));
            rolRepository.saveAll(List.of(admin, user));

            // Crear usuario de ejemplo
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario("admin");
            usuario.setCorreoUsuario("admin123@gmail.com");
            usuario.setRol(admin);
            usuario.setEstado(activo);
            usuarioRepository.save(usuario);

            System.out.println("📦 Base de datos precargada con datos iniciales.");
        };
    }
}
