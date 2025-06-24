package com.example.microservicio.de.gestion.de.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio.de.gestion.de.usuarios.model.Rol;
import com.example.microservicio.de.gestion.de.usuarios.repository.RolRepository;

@Service

public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodosLosRol() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerRolPorId(Long idRol) {
        return rolRepository.findById(idRol);
    }

    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol actualizarRol(Long idRol, Rol rolActualizado) {
        return rolRepository.findById(idRol).map(rolExistente -> {
            rolExistente.setNombreRol(rolActualizado.getNombreRol());
            rolExistente.setDescripcionRol(rolActualizado.getDescripcionRol());
            rolExistente.setPermisosRol(rolActualizado.getPermisosRol());
            return rolRepository.save(rolExistente);
        }).orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + idRol));
    }

    public void eliminarRol(Long idRol) {
        if (!rolRepository.existsById(idRol)) {
            throw new RuntimeException("Rol no encontrado con ID: " + idRol);
        }
        rolRepository.deleteById(idRol);
    }
}
