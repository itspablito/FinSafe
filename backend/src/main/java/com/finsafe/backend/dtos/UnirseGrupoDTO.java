package com.finsafe.backend.dtos;

import jakarta.validation.constraints.NotBlank;

public class UnirseGrupoDTO {

    @NotBlank(message = "El código de invitación es obligatorio")
    private String codigoInvitacion;

    public String getCodigoInvitacion() { return codigoInvitacion; }
    public void setCodigoInvitacion(String codigoInvitacion) { this.codigoInvitacion = codigoInvitacion; }
}