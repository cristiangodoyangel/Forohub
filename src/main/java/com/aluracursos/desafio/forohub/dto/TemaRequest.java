package com.aluracursos.desafio.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public class TemaRequest {

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;

    @NotBlank(message = "La categoría no puede estar vacía")
    private String categoria;

    // Getters y Setters
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
