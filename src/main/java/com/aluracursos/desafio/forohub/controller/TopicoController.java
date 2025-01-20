package com.aluracursos.desafio.forohub.controller;

import com.aluracursos.desafio.forohub.dto.TopicoDTO;
import com.aluracursos.desafio.forohub.entity.Topico;
import com.aluracursos.desafio.forohub.repository.TopicoRepository;
import com.aluracursos.desafio.forohub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    // Obtener todos los tópicos
    @GetMapping
    public List<Topico> listarTodos() {
        return topicoRepository.findAll();
    }

    // Obtener los primeros 10 tópicos ordenados por fecha de creación (ascendente)
    @GetMapping("/primeros10")
    public List<Topico> listarPrimeros10() {
        return topicoRepository.findTop10ByOrderByFechaCreacionAsc();
    }

    // Crear un nuevo tópico
    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid Topico nuevoTopico) {
        Topico topicoGuardado = topicoRepository.save(nuevoTopico);
        return ResponseEntity.status(201).body(topicoGuardado);
    }

    // Obtener un tópico específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopico(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un tópico existente
    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid Topico topicoActualizado) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(topicoActualizado.getTitulo());
            topico.setMensaje(topicoActualizado.getMensaje());
            topico.setFechaCreacion(topicoActualizado.getFechaCreacion());
            Topico actualizado = topicoRepository.save(topico);
            return ResponseEntity.ok(actualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un tópico
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarTopico(@PathVariable Long id) {
        return topicoRepository.findById(id).map(topico -> {
            topicoRepository.delete(topico);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDTO> obtenerTopicoPorId(@PathVariable Long id) {
        TopicoDTO topico = topicoService.obtenerTopicoPorId(id);
        return ResponseEntity.ok(topico);
    }
}
