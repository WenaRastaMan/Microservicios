package com.example.microservicio.de.gestion.de.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicio.de.gestion.de.usuarios.model.Rol;
import com.example.microservicio.de.gestion.de.usuarios.service.RolService;

@RequestMapping("/roles")
@RestController

public class RolController {
@Autowired
private RolService rolService;

@GetMapping
public ResponseEntity<List<Rol>> obtenerTodosLosRoles() {
    List<Rol> roles = rolService.obtenerTodosLosRol();
    return ResponseEntity.ok(roles);
}

@GetMapping("/{id}")
public ResponseEntity<Rol> obtenerRolPorId(@PathVariable Long id) {
    return rolService.obtenerRolPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@PostMapping
public ResponseEntity<Rol> crearRol(@RequestBody Rol rol) {
    Rol nuevoRol = rolService.guardarRol(rol);
    return ResponseEntity.ok(nuevoRol);
}

@PutMapping("/{id}")
public ResponseEntity<Rol> actualizarRol(@PathVariable Long id, @RequestBody Rol rolActualizado) {
    try {
        Rol actualizado = rolService.actualizarRol(id, rolActualizado);
        return ResponseEntity.ok(actualizado);
    } catch (RuntimeException e) {
        return ResponseEntity.notFound().build();
    }
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
    try {
        rolService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    } catch (RuntimeException e) {
        return ResponseEntity.notFound().build();
    }
}
}
