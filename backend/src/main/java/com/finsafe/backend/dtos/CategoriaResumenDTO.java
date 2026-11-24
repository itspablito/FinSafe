package com.finsafe.backend.dtos;

import java.math.BigDecimal;

public class CategoriaResumenDTO {
    private String categoria;
    private BigDecimal total;
    private double porcentaje;

    public CategoriaResumenDTO(String categoria, BigDecimal total, double porcentaje) {
        this.categoria = categoria;
        this.total = total;
        this.porcentaje = porcentaje;
    }

    public String getCategoria() { return categoria; }
    public BigDecimal getTotal() { return total; }
    public double getPorcentaje() { return porcentaje; }
}