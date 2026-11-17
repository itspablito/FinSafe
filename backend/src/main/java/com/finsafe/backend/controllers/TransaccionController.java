package com.finsafe.backend.controllers;

import com.finsafe.backend.dtos.TransaccionDTO;
import com.finsafe.backend.models.Transaccion;
import com.finsafe.backend.services.TransaccionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacciones/usuario/{usuarioId}")
public class TransaccionController {

    
    private final TransaccionService transaccionService;
    public TransaccionController(TransaccionService transaccionService) {
    this.transaccionService = transaccionService;
}

    // POST: /api/transacciones/usuario/1
    @PostMapping
    public ResponseEntity<?> registrar(@PathVariable Long usuarioId, @Valid @RequestBody TransaccionDTO dto) {
        try {
            Transaccion nuevaTransaccion = transaccionService.registrarTransaccion(usuarioId, dto);
            return new ResponseEntity<>(nuevaTransaccion, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // GET: /api/transacciones/usuario/1
    @GetMapping
    public ResponseEntity<List<Transaccion>> listarPropias(@PathVariable Long usuarioId) {
        List<Transaccion> transacciones = transaccionService.obtenerTransaccionesPorUsuario(usuarioId);
        return new ResponseEntity<>(transacciones, HttpStatus.OK);
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<String> manejarErroresDeValidacion(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        // Extrae el mensaje específico que definiste en las anotaciones del DTO
        String mensajeDeError = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResponseEntity<>(mensajeDeError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<String> manejarErrorDeFormato(org.springframework.http.converter.HttpMessageNotReadableException ex) {
        return new ResponseEntity<>("Categoría inexistente o formato de datos incorrecto", HttpStatus.BAD_REQUEST);
    }
}