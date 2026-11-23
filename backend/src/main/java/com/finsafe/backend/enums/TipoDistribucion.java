package com.finsafe.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoDistribucion {
    PARTES_IGUALES,
    MONTOS_EXACTOS;

    @JsonCreator
    public static TipoDistribucion fromString(String value) {
        if (value == null) return null;
        return TipoDistribucion.valueOf(value.trim().toUpperCase());
    }
}