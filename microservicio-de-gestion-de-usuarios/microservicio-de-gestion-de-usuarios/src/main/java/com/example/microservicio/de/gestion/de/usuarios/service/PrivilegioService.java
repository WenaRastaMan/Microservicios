package com.example.microservicio.de.gestion.de.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.microservicio.de.gestion.de.usuarios.model.Privilegio;
import com.example.microservicio.de.gestion.de.usuarios.repository.PrivilegioRepository;

public class PrivilegioService {
@Autowired
private PrivilegioRepository privilegioRepository;

public List<Privilegio> obtenerTodosLosPrivilegio() {
    return privilegioRepository.findAll();
}

public Optional<Privilegio> obtenerPrivilegioPorId(Long id) {
    return privilegioRepository.findById(id);
}

public Privilegio guardarPrivilegio(Privilegio privilegio) {
    return privilegioRepository.save(privilegio);
}

public Privilegio actualizarPrivilegio(Long id, Privilegio privilegioActualizado) {
    Optional<Privilegio> privilegioExistente = privilegioRepository.findById(id);
    if (privilegioExistente.isPresent()) {
        Privilegio privilegio = privilegioExistente.get();
        privilegio.setNombrePrivilegio(privilegioActualizado.getNombrePrivilegio());
        privilegio.setDescripcionPrivilegio(privilegioActualizado.getDescripcionPrivilegio());
        privilegio.setPermisosPrivilegio(privilegioActualizado.getPermisosPrivilegio());
        return privilegioRepository.save(privilegio);
    } else {
        throw new RuntimeException("Privilegio no encontrado con ID: " + id);
    }
}

public void eliminarPrivilegio(Long id) {
    privilegioRepository.deleteById(id);
}
}
