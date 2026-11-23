package com.finsafe.backend.dtos;

import java.math.BigDecimal;

public class DeudaSimplificadaDTO {
    private Long deudorId;
    private String nombreDeudor;
    private Long acreedorId;
    private String nombreAcreedor;
    private BigDecimal monto;

    public DeudaSimplificadaDTO(Long deudorId, String nombreDeudor, Long acreedorId, String nombreAcreedor, BigDecimal monto) {
        this.deudorId = deudorId;
        this.nombreDeudor = nombreDeudor;
        this.acreedorId = acreedorId;
        this.nombreAcreedor = nombreAcreedor;
        this.monto = monto;
    }

    // Getters
    public Long getDeudorId() { return deudorId; }
    public String getNombreDeudor() { return nombreDeudor; }
    public Long getAcreedorId() { return acreedorId; }
    public String getNombreAcreedor() { return nombreAcreedor; }
    public BigDecimal getMonto() { return monto; }
}