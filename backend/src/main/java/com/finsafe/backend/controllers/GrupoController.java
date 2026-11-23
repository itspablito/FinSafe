package com.finsafe.backend.controllers;

import com.finsafe.backend.dtos.CrearGrupoDTO;
import com.finsafe.backend.models.Grupo;
import com.finsafe.backend.services.GrupoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.finsafe.backend.dtos.UnirseGrupoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    // POST: /api/grupos/usuario/1
    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> crearGrupo(@PathVariable Long usuarioId, @Valid @RequestBody CrearGrupoDTO dto) {
        try {
            Grupo grupoCreado = grupoService.crearGrupo(usuarioId, dto);
            return new ResponseEntity<>(grupoCreado, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // GET: /api/grupos/usuario/1
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> listarGruposUsuario(@PathVariable Long usuarioId) {
        try {
            List<Grupo> grupos = grupoService.obtenerGruposPorUsuario(usuarioId);
            return new ResponseEntity<>(grupos, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // GET: /api/grupos/1/usuario/1
    @GetMapping("/{grupoId}/usuario/{usuarioId}")
    public ResponseEntity<?> obtenerDetalleGrupo(@PathVariable Long grupoId, @PathVariable Long usuarioId) {
        try {
            Grupo grupo = grupoService.obtenerDetalleGrupo(grupoId, usuarioId);
            return new ResponseEntity<>(grupo, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    // POST: /api/grupos/unirse/usuario/2
    @PostMapping("/unirse/usuario/{usuarioId}")
    public ResponseEntity<?> unirseAGrupo(@PathVariable Long usuarioId, @Valid @RequestBody UnirseGrupoDTO dto) {
        try {
            Grupo grupoActualizado = grupoService.unirseAGrupo(usuarioId, dto.getCodigoInvitacion());
            return new ResponseEntity<>(grupoActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}