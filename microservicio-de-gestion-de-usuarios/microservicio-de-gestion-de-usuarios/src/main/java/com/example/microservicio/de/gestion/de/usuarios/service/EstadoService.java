package com.example.microservicio.de.gestion.de.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio.de.gestion.de.usuarios.model.Estado;
import com.example.microservicio.de.gestion.de.usuarios.repository.EstadoRepository;

@Service

public class EstadoService {
     @Autowired
    private EstadoRepository estadoRepository;

    // Obtener todos los estados
    public List<Estado> listarEstados() {
        return estadoRepository.findAll();
    }

    // Obtener estado por ID
    public Optional<Estado> obtenerEstadoPorId(Long id) {
        return estadoRepository.findById(id);
    }

    // Crear nuevo estado
    public Estado crearEstado(Estado estado) {
        // Validación simple de campos
        if (estado.getNombre() == null || estado.getDescripcion() == null) {
            throw new IllegalArgumentException("El nombre y la descripción no pueden ser nulos.");
        }

        return estadoRepository.save(estado);
    }

    // Actualizar estado existente
    public Estado actualizarEstado(Long id, Estado estadoActualizado) {
        return estadoRepository.findById(id)
                .map(estado -> {
                    estado.setNombre(estadoActualizado.getNombre());
                    estado.setDescripcion(estadoActualizado.getDescripcion());
                    return estadoRepository.save(estado);
                })
                .orElseThrow(() -> new IllegalArgumentException("Estado no encontrado con ID: " + id));
    }

    // Eliminar estado
    public void eliminarEstado(Long id) {
        if (!estadoRepository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar. Estado no encontrado.");
        }
        estadoRepository.deleteById(id);
    }
}

