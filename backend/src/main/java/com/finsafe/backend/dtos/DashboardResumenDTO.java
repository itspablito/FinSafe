package com.finsafe.backend.dtos;

import java.math.BigDecimal;
import java.util.List;

public class DashboardResumenDTO {
    private Long usuarioId;
    private String nombreUsuario;
    private BigDecimal totalIngresos;
    private BigDecimal totalGastos;
    private BigDecimal balanceGeneral;
    private int cantidadMovimientos;
    private List<CategoriaResumenDTO> distribucionGastosPorCategoria;

    public DashboardResumenDTO(Long usuarioId, String nombreUsuario, BigDecimal totalIngresos,
                               BigDecimal totalGastos, BigDecimal balanceGeneral, int cantidadMovimientos,
                               List<CategoriaResumenDTO> distribucionGastosPorCategoria) {
        this.usuarioId = usuarioId;
        this.nombreUsuario = nombreUsuario;
        this.totalIngresos = totalIngresos;
        this.totalGastos = totalGastos;
        this.balanceGeneral = balanceGeneral;
        this.cantidadMovimientos = cantidadMovimientos;
        this.distribucionGastosPorCategoria = distribucionGastosPorCategoria;
    }

    public Long getUsuarioId() { return usuarioId; }
    public String getNombreUsuario() { return nombreUsuario; }
    public BigDecimal getTotalIngresos() { return totalIngresos; }
    public BigDecimal getTotalGastos() { return totalGastos; }
    public BigDecimal getBalanceGeneral() { return balanceGeneral; }
    public int getCantidadMovimientos() { return cantidadMovimientos; }
    public List<CategoriaResumenDTO> getDistribucionGastosPorCategoria() { return distribucionGastosPorCategoria; }
}