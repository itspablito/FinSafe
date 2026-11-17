package com.finsafe.backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.finsafe.backend.enums.CategoriaFinanciera;

public class TransaccionDTO {

    @NotNull(message = "El valor es obligatorio")
    @Positive(message = "El valor debe ser mayor a cero") // Cumple con el criterio de validación de la EDT
    private BigDecimal valor;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotBlank(message = "El tipo es obligatorio (INGRESO o GASTO)")
    private String tipo; // "INGRESO" o "GASTO"

    @JsonAlias("categoria")
    @NotNull(message = "La categoría es obligatoria y debe ser válida")
    private CategoriaFinanciera categoria;

    // Getters y Setters
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public CategoriaFinanciera getCategoria() { return categoria; }
    public void setCategoria(CategoriaFinanciera categoria) { this.categoria = categoria; }
}