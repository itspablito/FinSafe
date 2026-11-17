package com.finsafe.backend.controllers;

import com.finsafe.backend.dtos.PresupuestoDTO;
import com.finsafe.backend.dtos.PresupuestoRespuestaDTO;
import com.finsafe.backend.services.PresupuestoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/presupuestos/usuario/{usuarioId}")
public class PresupuestoController {

    private final PresupuestoService presupuestoService;

    public PresupuestoController(PresupuestoService presupuestoService) {
        this.presupuestoService = presupuestoService;
    }

    @PostMapping
    public ResponseEntity<?> configurarPresupuesto(@PathVariable Long usuarioId, @Valid @RequestBody PresupuestoDTO dto) {
        try {
            PresupuestoRespuestaDTO respuesta = presupuestoService.configurarPresupuesto(usuarioId, dto);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> consultarPresupuesto(
            @PathVariable Long usuarioId,
            @RequestParam Integer mes,
            @RequestParam Integer anio) {
        try {
            PresupuestoRespuestaDTO respuesta = presupuestoService.obtenerResumenPresupuesto(usuarioId, mes, anio);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}