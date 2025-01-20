package com.aluracursos.desafio.forohub.dto;

import com.aluracursos.desafio.forohub.entity.Topico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TopicoDTO {

    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    private String estado;
    private String autor;
    private String curso;

    // Constructor que acepta un objeto Topico
    public TopicoDTO(Topico topico) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.titulo = topico.getTitulo();
        this.mensaje = topico.getMensaje();
        this.fechaCreacion = (topico.getFechaCreacion() != null)
                ? topico.getFechaCreacion().format(formatter)
                : null;
        this.estado = topico.getEstado();
        this.autor = topico.getAutor();
        this.curso = topico.getCurso();
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
