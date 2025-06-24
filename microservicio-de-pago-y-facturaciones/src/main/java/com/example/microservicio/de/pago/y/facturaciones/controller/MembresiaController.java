package com.example.microservicio.de.pago.y.facturaciones.controller;

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

import com.example.microservicio.de.pago.y.facturaciones.model.Membresia;
import com.example.microservicio.de.pago.y.facturaciones.service.MembresiaService;

@RestController
@RequestMapping("/membresias")

public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    @GetMapping
    public List<Membresia> getAllMembresias() {
        return membresiaService.obtenerTodasLasMembresias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membresia> getMembresiaById(@PathVariable Long id) {
        return membresiaService.obtenerMembresiaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Membresia createMembresia(@RequestBody Membresia membresia) {
        return membresiaService.crearMembresia(membresia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membresia> updateMembresia(@PathVariable Long id, @RequestBody Membresia membresia) {
        return membresiaService.actualizarMembresia(id, membresia)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembresia(@PathVariable Long id) {
        return membresiaService.eliminarMembresia(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
