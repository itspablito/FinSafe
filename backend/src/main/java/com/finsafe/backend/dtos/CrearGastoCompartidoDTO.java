package com.finsafe.backend.dtos;

import com.finsafe.backend.enums.TipoDistribucion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CrearGastoCompartidoDTO {

    @NotBlank(message = "La descripción del gasto es obligatoria")
    private String descripcion;

    @NotNull(message = "El monto total es obligatorio")
    @Positive(message = "El valor del gasto debe ser mayor a cero")
    private BigDecimal montoTotal;

    @NotNull(message = "La fecha del gasto es obligatoria")
    private LocalDate fecha;

    @NotNull(message = "El ID del usuario que pagó es obligatorio")
    private Long pagadorId;

    @NotNull(message = "El tipo de distribución es obligatorio (PARTES_IGUALES o MONTOS_EXACTOS)")
    private TipoDistribucion tipoDistribucion;

    // Opcional si es PARTES_IGUALES; obligatorio si es MONTOS_EXACTOS
    @Valid
    private List<DetalleDistribucionDTO> detalles;

    // Getters y Setters
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public BigDecimal getMontoTotal() { return montoTotal; }
    public void setMontoTotal(BigDecimal montoTotal) { this.montoTotal = montoTotal; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public Long getPagadorId() { return pagadorId; }
    public void setPagadorId(Long pagadorId) { this.pagadorId = pagadorId; }
    public TipoDistribucion getTipoDistribucion() { return tipoDistribucion; }
    public void setTipoDistribucion(TipoDistribucion tipoDistribucion) { this.tipoDistribucion = tipoDistribucion; }
    public List<DetalleDistribucionDTO> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleDistribucionDTO> detalles) { this.detalles = detalles; }
}