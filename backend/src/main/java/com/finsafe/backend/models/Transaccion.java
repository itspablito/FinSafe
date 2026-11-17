package com.finsafe.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finsafe.backend.enums.CategoriaFinanciera;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String tipo; // "INGRESO" o "GASTO"

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaFinanciera categoria;

    // Relación con el Usuario: Muchas transacciones pertenecen a un usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnore // Evita ciclos infinitos al devolver el JSON en el controlador
    private Usuario usuario;

    // Constructores
    public Transaccion() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}