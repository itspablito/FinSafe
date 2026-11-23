package com.finsafe.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_gastos_compartidos")
public class DetalleGastoCompartido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gasto_compartido_id", nullable = false)
    private GastoCompartido gastoCompartido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal montoAsignado;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public GastoCompartido getGastoCompartido() { return gastoCompartido; }
    public void setGastoCompartido(GastoCompartido gastoCompartido) { this.gastoCompartido = gastoCompartido; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public BigDecimal getMontoAsignado() { return montoAsignado; }
    public void setMontoAsignado(BigDecimal montoAsignado) { this.montoAsignado = montoAsignado; }
}