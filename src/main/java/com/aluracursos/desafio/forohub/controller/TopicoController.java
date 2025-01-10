package com.aluracursos.desafio.forohub.controller;

import com.aluracursos.desafio.forohub.dto.TopicoRequest;
import com.aluracursos.desafio.forohub.entity.Topico;
import com.aluracursos.desafio.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<?> registrarTopico(@RequestBody @Valid TopicoRequest topicoRequest) {
        // Validar duplicados
        if (topicoRepository.existsByTituloAndMensaje(topicoRequest.getTitulo(), topicoRequest.getMensaje())) {
            return ResponseEntity.badRequest().body("Ya existe un tópico con el mismo título y mensaje.");
        }

        // Convertir DTO a entidad
        Topico topico = new Topico();
        topico.setTitulo(topicoRequest.getTitulo());
        topico.setMensaje(topicoRequest.getMensaje());
        topico.setAutor(topicoRequest.getAutor());
        topico.setCurso(topicoRequest.getCurso());

        // Guardar en la base de datos
        topicoRepository.save(topico);

        return ResponseEntity.ok("Tópico registrado con éxito.");
    }
}
