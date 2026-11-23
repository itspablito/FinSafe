package com.finsafe.backend.dtos;

import java.math.BigDecimal;
import java.util.List;

public class BalanceGrupoDTO {
    private Long grupoId;
    private String nombreGrupo;
    private BigDecimal gastoTotalGrupo;
    private List<SaldoParticipanteDTO> saldosIndividuales;
    private List<DeudaSimplificadaDTO> liquidacionSugerida;

    public BalanceGrupoDTO(Long grupoId, String nombreGrupo, BigDecimal gastoTotalGrupo,
                           List<SaldoParticipanteDTO> saldosIndividuales,
                           List<DeudaSimplificadaDTO> liquidacionSugerida) {
        this.grupoId = grupoId;
        this.nombreGrupo = nombreGrupo;
        this.gastoTotalGrupo = gastoTotalGrupo;
        this.saldosIndividuales = saldosIndividuales;
        this.liquidacionSugerida = liquidacionSugerida;
    }

    // Getters
    public Long getGrupoId() { return grupoId; }
    public String getNombreGrupo() { return nombreGrupo; }
    public BigDecimal getGastoTotalGrupo() { return gastoTotalGrupo; }
    public List<SaldoParticipanteDTO> getSaldosIndividuales() { return saldosIndividuales; }
    public List<DeudaSimplificadaDTO> getLiquidacionSugerida() { return liquidacionSugerida; }
}