package com.finsafe.backend.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true, updatable = false)
    private String codigoInvitacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creador_id", nullable = false)
    private Usuario creador;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "grupo_integrantes",
        joinColumns = @JoinColumn(name = "grupo_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<Usuario> integrantes = new HashSet<>();

    @PrePersist
    public void generarCodigoInvitacion() {
        if (this.codigoInvitacion == null) {
            this.codigoInvitacion = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        }
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCodigoInvitacion() { return codigoInvitacion; }
    public void setCodigoInvitacion(String codigoInvitacion) { this.codigoInvitacion = codigoInvitacion; }
    public Usuario getCreador() { return creador; }
    public void setCreador(Usuario creador) { this.creador = creador; }
    public Set<Usuario> getIntegrantes() { return integrantes; }
    public void setIntegrantes(Set<Usuario> integrantes) { this.integrantes = integrantes; }
}