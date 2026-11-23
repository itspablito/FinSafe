package com.finsafe.backend.dtos;

import java.math.BigDecimal;

public class SaldoParticipanteDTO {
    private Long usuarioId;
    private String nombre;
    private BigDecimal totalPagado;
    private BigDecimal totalConsumido;
    private BigDecimal balanceNeto; // Positivo: le deben | Negativo: debe | Cero: al día

    public SaldoParticipanteDTO(Long usuarioId, String nombre, BigDecimal totalPagado, BigDecimal totalConsumido, BigDecimal balanceNeto) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.totalPagado = totalPagado;
        this.totalConsumido = totalConsumido;
        this.balanceNeto = balanceNeto;
    }

    // Getters
    public Long getUsuarioId() { return usuarioId; }
    public String getNombre() { return nombre; }
    public BigDecimal getTotalPagado() { return totalPagado; }
    public BigDecimal getTotalConsumido() { return totalConsumido; }
    public BigDecimal getBalanceNeto() { return balanceNeto; }
}