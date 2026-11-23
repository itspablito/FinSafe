package com.finsafe.backend.services;

import com.finsafe.backend.dtos.CrearGrupoDTO;
import com.finsafe.backend.models.Grupo;
import com.finsafe.backend.models.Usuario;
import com.finsafe.backend.repositories.GrupoRepository;
import com.finsafe.backend.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    private final GrupoRepository grupoRepository;
    private final UsuarioRepository usuarioRepository;

    public GrupoService(GrupoRepository grupoRepository, UsuarioRepository usuarioRepository) {
        this.grupoRepository = grupoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // 1. Crear un grupo y asociarlo a su creador
    public Grupo crearGrupo(Long creadorId, CrearGrupoDTO dto) {
        Usuario creador = usuarioRepository.findById(creadorId)
                .orElseThrow(() -> new RuntimeException("Usuario creador no encontrado"));

        Grupo nuevoGrupo = new Grupo();
        nuevoGrupo.setNombre(dto.getNombre());
        nuevoGrupo.setCreador(creador);
        
        // El creador también debe formar parte de la lista de integrantes
        nuevoGrupo.getIntegrantes().add(creador);

        return grupoRepository.save(nuevoGrupo);
    }

    // 2. Consultar los grupos a los que pertenece un usuario
    public List<Grupo> obtenerGruposPorUsuario(Long usuarioId) {
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        return grupoRepository.findByIntegrantesId(usuarioId);
    }

    // 3. Consultar el detalle e integrantes de un grupo (validando pertenencia)
    public Grupo obtenerDetalleGrupo(Long grupoId, Long usuarioId) {
        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        // Criterio EDT 1.4.1: Controlar el acceso según la pertenencia al grupo
        boolean esIntegrante = grupo.getIntegrantes().stream()
                .anyMatch(u -> u.getId().equals(usuarioId));

        if (!esIntegrante) {
            throw new RuntimeException("Acceso denegado: No perteneces a este grupo");
        }

        return grupo;
    }

    // 4. Unirse a un grupo mediante código de invitación 
    public Grupo unirseAGrupo(Long usuarioId, String codigoInvitacion) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Limpiamos espacios y pasamos a mayúsculas por si el usuario lo escribe en minúscula
        String codigoLimpio = codigoInvitacion.trim().toUpperCase();

        Grupo grupo = grupoRepository.findByCodigoInvitacion(codigoLimpio)
                .orElseThrow(() -> new RuntimeException("Código de invitación inválido o no existe"));

        //  No permitir incorporaciones duplicadas
        boolean yaEsIntegrante = grupo.getIntegrantes().stream()
                .anyMatch(u -> u.getId().equals(usuarioId));

        if (yaEsIntegrante) {
            throw new RuntimeException("El usuario ya pertenece a este grupo");
        }

        grupo.getIntegrantes().add(usuario);
        return grupoRepository.save(grupo);
    }

}