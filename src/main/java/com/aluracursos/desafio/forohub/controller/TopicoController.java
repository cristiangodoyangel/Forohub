package com.aluracursos.desafio.forohub.controller;

import com.aluracursos.desafio.forohub.dto.TopicoRequest;
import com.aluracursos.desafio.forohub.entity.Topico;
import com.aluracursos.desafio.forohub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;

    public TopicoController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    // Crear un nuevo tópico
    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid TopicoRequest topicoRequest) {
        Topico topico = new Topico();
        topico.setTitulo(topicoRequest.getTitulo());
        topico.setMensaje(topicoRequest.getMensaje());
        topico.setCategoria(topicoRequest.getCategoria());
        topicoRepository.save(topico);
        return ResponseEntity.status(201).body(topico);
    }

    // Listar todos los tópicos
    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        return ResponseEntity.ok(topicos);
    }

    // Obtener un tópico específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un tópico
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTopico(@PathVariable Long id, @RequestBody @Valid TopicoRequest topicoRequest) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);

        if (topicoExistente.isPresent()) {
            Topico topico = topicoExistente.get();
            topico.setTitulo(topicoRequest.getTitulo());
            topico.setMensaje(topicoRequest.getMensaje());
            topico.setCategoria(topicoRequest.getCategoria());
            topicoRepository.save(topico);
            return ResponseEntity.ok(topico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un tópico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            topicoRepository.delete(topico.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
