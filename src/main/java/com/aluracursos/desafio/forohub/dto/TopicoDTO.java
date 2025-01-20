package com.aluracursos.desafio.forohub.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TopicoDTO {

    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    private String estado;
    private String autor;
    private String curso;

    // Constructor que acepta todos los campos
    public TopicoDTO(String titulo, String mensaje, LocalDateTime fechaCreacion, String estado, String autor, String curso) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = (fechaCreacion != null) ? fechaCreacion.format(formatter) : null;
        this.estado = estado;
        this.autor = autor;
        this.curso = curso;
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
