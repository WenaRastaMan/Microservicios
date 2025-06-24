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

import com.example.microservicio.de.gestion.de.usuarios.model.Privilegio;
import com.example.microservicio.de.gestion.de.usuarios.service.PrivilegioService;

@RequestMapping("/privilegios")
@RestController

public class PrivilegioController {
@Autowired
private PrivilegioService privilegioService;

@GetMapping
public ResponseEntity<List<Privilegio>> listarTodos() {
    return ResponseEntity.ok(privilegioService.obtenerTodosLosPrivilegio());
}

@GetMapping("/{id}")
public ResponseEntity<Privilegio> obtenerPorId(@PathVariable Long id) {
    return privilegioService.obtenerPrivilegioPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@PostMapping
public ResponseEntity<Privilegio> crearPrivilegio(@RequestBody Privilegio privilegio) {
    return ResponseEntity.ok(privilegioService.guardarPrivilegio(privilegio));
}

@PutMapping("/{id}")
public ResponseEntity<Privilegio> actualizarPrivilegio(@PathVariable Long id, @RequestBody Privilegio privilegio) {
    try {
        Privilegio actualizado = privilegioService.actualizarPrivilegio
        (id, privilegio);
        return ResponseEntity.ok(actualizado);
    } catch (RuntimeException e) {
        return ResponseEntity.notFound().build();
    }
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarPrivilegio(@PathVariable Long id) {
    privilegioService.eliminarPrivilegio(id);
    return ResponseEntity.noContent().build();
}

}
