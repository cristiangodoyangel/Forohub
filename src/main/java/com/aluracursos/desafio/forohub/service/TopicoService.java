package com.aluracursos.desafio.forohub.service;
import com.aluracursos.desafio.forohub.dto.TopicoDTO;
import com.aluracursos.desafio.forohub.repository.TopicoRepository;
import org.springframework.stereotype.Service;
import com.aluracursos.desafio.forohub.exception.RecursoNoEncontradoException;
@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public TopicoDTO obtenerTopicoPorId(Long id) {
        return topicoRepository.findById(id)
                .map(topico -> new TopicoDTO(
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getFechaCreacion(),
                        topico.getEstado(),
                        topico.getAutor(),
                        topico.getCurso()
                ))
                .orElseThrow(() -> new RecursoNoEncontradoException("Tópico no encontrado con ID: " + id));
    }
}
