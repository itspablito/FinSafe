package com.finsafe.backend.dtos;

import java.math.BigDecimal;

public class PresupuestoRespuestaDTO {
    private Integer mes;
    private Integer anio;
    private BigDecimal limite;
    private BigDecimal gastoAcumulado;
    private BigDecimal saldoDisponible;

    // Getters y Setters
    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }
    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }
    public BigDecimal getLimite() { return limite; }
    public void setLimite(BigDecimal limite) { this.limite = limite; }
    public BigDecimal getGastoAcumulado() { return gastoAcumulado; }
    public void setGastoAcumulado(BigDecimal gastoAcumulado) { this.gastoAcumulado = gastoAcumulado; }
    public BigDecimal getSaldoDisponible() { return saldoDisponible; }
    public void setSaldoDisponible(BigDecimal saldoDisponible) { this.saldoDisponible = saldoDisponible; }
}