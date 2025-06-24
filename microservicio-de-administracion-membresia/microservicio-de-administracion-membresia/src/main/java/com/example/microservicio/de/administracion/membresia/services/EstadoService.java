package com.example.microservicio.de.administracion.membresia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio.de.administracion.membresia.model.Estado;
import com.example.microservicio.de.administracion.membresia.repository.EstadoRepository;

@Service

public class EstadoService {
    
    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> obtenerTodos() {
        return estadoRepository.findAll();
    }

    public Optional<Estado> obtenerPorId(Long id) {
        return estadoRepository.findById(id);
    }

    public Estado guardarTodo(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado actualizar(Long id, Estado estadoActualizado) {
        return estadoRepository.findById(id)
            .map(estado -> {
                estado.setNombre(estadoActualizado.getNombre());
                // Agrega aquí otros campos que desees actualizar
                return estadoRepository.save(estado);
            })
            .orElseThrow(() -> new RuntimeException("Estado no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        estadoRepository.deleteById(id);
    }
}
