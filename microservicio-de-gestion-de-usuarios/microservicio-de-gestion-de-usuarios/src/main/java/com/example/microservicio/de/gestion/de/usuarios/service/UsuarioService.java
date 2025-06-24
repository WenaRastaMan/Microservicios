package com.example.microservicio.de.gestion.de.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio.de.gestion.de.usuarios.model.Usuario;
import com.example.microservicio.de.gestion.de.usuarios.repository.UsuarioRepository;

@Service

public class UsuarioService {
     @Autowired
    private UsuarioRepository usuarioRepository;

    // Crear nuevo usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Actualizar un usuario
    public Optional<Usuario> actualizarUsuario(Long id, Usuario usuarioActualizado) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombreUsuario(usuarioActualizado.getNombreUsuario());
            usuario.setApellidoUsuario(usuarioActualizado.getApellidoUsuario());
            usuario.setTelefonoUsuario(usuarioActualizado.getTelefonoUsuario());
            usuario.setDireccionUsuario(usuarioActualizado.getDireccionUsuario());
            usuario.setCorreoUsuario(usuarioActualizado.getCorreoUsuario());
            usuario.setClaveUsuario(usuarioActualizado.getClaveUsuario());
            return usuarioRepository.save(usuario);
        });
    }

    // Eliminar un usuario
    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
