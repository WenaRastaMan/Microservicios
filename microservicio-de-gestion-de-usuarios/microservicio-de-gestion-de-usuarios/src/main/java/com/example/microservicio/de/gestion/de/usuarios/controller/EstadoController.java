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

import com.example.microservicio.de.gestion.de.usuarios.model.Estado;
import com.example.microservicio.de.gestion.de.usuarios.service.EstadoService;

@RestController
@RequestMapping("/api/estado_usuario")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    // GET /estados
    @GetMapping
    public ResponseEntity<List<Estado>> listarEstados() {
        return ResponseEntity.ok(estadoService.listarEstados());
    }

    // GET /estados/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Estado> obtenerEstadoPorId(@PathVariable Long id) {
        return estadoService.obtenerEstadoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /estados
    @PostMapping
    public ResponseEntity<Estado> crearEstado(@RequestBody Estado estado) {
        try {
            Estado nuevoEstado = estadoService.crearEstado(estado);
            return ResponseEntity.ok(nuevoEstado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // PUT /estados/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Estado> actualizarEstado(@PathVariable Long id, @RequestBody Estado estado) {
        try {
            Estado actualizado = estadoService.actualizarEstado(id, estado);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /estados/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstado(@PathVariable Long id) {
        try {
            estadoService.eliminarEstado(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

