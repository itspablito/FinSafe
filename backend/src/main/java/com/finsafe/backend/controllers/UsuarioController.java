package com.finsafe.backend.controllers;

import com.finsafe.backend.dtos.ActualizarPerfilDTO;
import com.finsafe.backend.dtos.LoginUsuarioDTO;
import com.finsafe.backend.dtos.RegistroUsuarioDTO;
import com.finsafe.backend.models.Usuario;
import com.finsafe.backend.security.JwtUtil;
import com.finsafe.backend.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    
    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public UsuarioController(UsuarioService usuarioService, JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody RegistroUsuarioDTO registroDTO) {
        try {
            Usuario usuarioRegistrado = usuarioService.registrarUsuario(registroDTO);
            return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUsuarioDTO loginDTO) {
        try {
            Usuario usuario = usuarioService.login(loginDTO);
            String token = jwtUtil.generarToken(usuario.getId(), usuario.getCorreoElectronico());

            java.util.Map<String, Object> respuesta = new java.util.HashMap<>();
            respuesta.put("mensaje", "Inicio de sesión exitoso");
            respuesta.put("token", token);
            respuesta.put("usuarioId", usuario.getId());
            respuesta.put("nombre", usuario.getNombre());

            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPerfil(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioService.obtenerPerfil(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPerfil(@PathVariable Long id, @Valid @RequestBody ActualizarPerfilDTO dto) {
        try {
            Usuario usuarioActualizado = usuarioService.actualizarPerfil(id, dto);
            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}