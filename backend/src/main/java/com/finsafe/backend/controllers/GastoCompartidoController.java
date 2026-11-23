package com.finsafe.backend.controllers;

import com.finsafe.backend.dtos.CrearGastoCompartidoDTO;
import com.finsafe.backend.models.GastoCompartido;
import com.finsafe.backend.services.GastoCompartidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.finsafe.backend.dtos.BalanceGrupoDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/grupos/{grupoId}/gastos")
public class GastoCompartidoController {

    private final GastoCompartidoService gastoCompartidoService;

    public GastoCompartidoController(GastoCompartidoService gastoCompartidoService) {
        this.gastoCompartidoService = gastoCompartidoService;
    }

    // POST: /api/grupos/1/gastos/usuario/1
    @PostMapping("/usuario/{usuarioSolicitanteId}")
    public ResponseEntity<?> registrarGasto(
            @PathVariable Long grupoId,
            @PathVariable Long usuarioSolicitanteId,
            @Valid @RequestBody CrearGastoCompartidoDTO dto) {
        try {
            GastoCompartido gastoCreado = gastoCompartidoService.registrarGastoCompartido(grupoId, usuarioSolicitanteId, dto);
            return new ResponseEntity<>(gastoCreado, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // GET: /api/grupos/1/gastos/usuario/1
    @GetMapping("/usuario/{usuarioSolicitanteId}")
    public ResponseEntity<?> consultarHistorial(
            @PathVariable Long grupoId,
            @PathVariable Long usuarioSolicitanteId) {
        try {
            List<GastoCompartido> historial = gastoCompartidoService.obtenerHistorialGrupo(grupoId, usuarioSolicitanteId);
            return new ResponseEntity<>(historial, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errores = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleJsonParseExceptions(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>("Formato inválido: Verifique que el tipo de distribución sea PARTES_IGUALES o MONTOS_EXACTOS y la fecha sea YYYY-MM-DD", HttpStatus.BAD_REQUEST);
    }

    // GET: /api/grupos/1/gastos/balances/usuario/1
    @GetMapping("/balances/usuario/{usuarioSolicitanteId}")
    public ResponseEntity<?> consultarBalances(
            @PathVariable Long grupoId,
            @PathVariable Long usuarioSolicitanteId) {
        try {
            BalanceGrupoDTO balance = gastoCompartidoService.calcularBalancesGrupo(grupoId, usuarioSolicitanteId);
            return new ResponseEntity<>(balance, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

}