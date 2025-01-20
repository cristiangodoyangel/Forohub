package com.aluracursos.desafio.forohub.repository;

import com.aluracursos.desafio.forohub.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
}
