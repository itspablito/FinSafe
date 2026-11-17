package com.finsafe.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CategoriaFinanciera {
    // Categorías de Ingresos
    SUELDO,
    HONORARIOS,
    RENDIMIENTOS,
    OTROS_INGRESOS,
    
    // Categorías de Gastos
    ALIMENTACION,
    VIVIENDA,
    TRANSPORTE,
    ENTRETENIMIENTO,
    SALUD,
    EDUCACION,
    OTROS_GASTOS;

    @JsonCreator
    public static CategoriaFinanciera fromString(String value) {
        return value == null ? null : CategoriaFinanciera.valueOf(value.trim().toUpperCase());
    }
}   