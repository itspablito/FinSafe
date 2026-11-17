package com.finsafe.backend.services;

import com.finsafe.backend.dtos.RegistroUsuarioDTO;
import com.finsafe.backend.models.Usuario;
import com.finsafe.backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Usuario registrarUsuario(RegistroUsuarioDTO dto) {
        // Regla: Evitar registro duplicado de la misma cuenta
        if (usuarioRepository.existsByCorreoElectronico(dto.getCorreoElectronico())) {
            throw new RuntimeException("El correo electrónico ya está registrado en FinSafe");
        }

        // Crear la entidad Usuario a partir del DTO
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(dto.getNombre());
        nuevoUsuario.setCorreoElectronico(dto.getCorreoElectronico());
        
        //  Almacenar contraseña con hash seguro
        String hashSeguro = passwordEncoder.encode(dto.getPassword());
        nuevoUsuario.setPasswordHash(hashSeguro);

        // Guardar en la base de datos
        return usuarioRepository.save(nuevoUsuario);
    }
}