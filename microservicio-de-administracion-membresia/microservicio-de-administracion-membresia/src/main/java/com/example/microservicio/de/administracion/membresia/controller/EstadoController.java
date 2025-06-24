package com.example.microservicio.de.administracion.membresia.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.microservicio.de.administracion.membresia.model.Estado;
import com.example.microservicio.de.administracion.membresia.services.EstadoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@RestController

public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping
    public List<Estado> listar() {
        return estadoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> obtenerPorId(@PathVariable Long id) {
        return estadoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estado> crear(@RequestBody Estado estado) {
        return ResponseEntity.ok(estadoService.guardarTodo(estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
