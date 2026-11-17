package com.finsafe.backend.services;

import com.finsafe.backend.dtos.ActualizarPerfilDTO;
import com.finsafe.backend.dtos.LoginUsuarioDTO;
import com.finsafe.backend.dtos.RegistroUsuarioDTO;
import com.finsafe.backend.models.Usuario;
import com.finsafe.backend.repositories.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

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

    public Usuario login(LoginUsuarioDTO dto) {
    // 1. Buscar al usuario por correo
    Usuario usuario = usuarioRepository.findByCorreoElectronico(dto.getCorreoElectronico())
            .orElseThrow(() -> new RuntimeException("Correo o contraseña incorrectos"));

    // 2. Verificar que la contraseña coincida con el hash
    if (!passwordEncoder.matches(dto.getPassword(), usuario.getPasswordHash())) {
        throw new RuntimeException("Correo o contraseña incorrectos");
    }

    // Si todo es correcto, devolvemos el usuario (más adelante aquí generaremos el JWT)
    return usuario;
    }

        // Método para consultar el perfil
    public Usuario obtenerPerfil(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Método para actualizar el perfil
    public Usuario actualizarPerfil(Long id, ActualizarPerfilDTO dto) {
        Usuario usuario = obtenerPerfil(id);

        // Si el usuario cambia su correo, debemos validar que el nuevo correo no esté en uso por otra persona
        if (!usuario.getCorreoElectronico().equals(dto.getCorreoElectronico()) && 
            usuarioRepository.existsByCorreoElectronico(dto.getCorreoElectronico())) {
            throw new RuntimeException("El nuevo correo electrónico ya está en uso");
        }

        usuario.setNombre(dto.getNombre());
        usuario.setCorreoElectronico(dto.getCorreoElectronico());
        
        // Guardamos los cambios para que persistan
        return usuarioRepository.save(usuario);
    }

}