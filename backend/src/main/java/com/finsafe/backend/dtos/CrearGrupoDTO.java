package com.finsafe.backend.dtos;

import jakarta.validation.constraints.NotBlank;

public class CrearGrupoDTO {

    @NotBlank(message = "El nombre del grupo es obligatorio")
    private String nombre;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}