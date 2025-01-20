package com.aluracursos.desafio.forohub.repository;

import com.aluracursos.desafio.forohub.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    // Método para obtener los primeros 10 tópicos ordenados por fecha de creación (ASC)
    List<Topico> findTop10ByOrderByFechaCreacionAsc();





}



