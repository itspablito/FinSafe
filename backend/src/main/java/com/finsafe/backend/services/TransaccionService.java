package com.finsafe.backend.services;

import com.finsafe.backend.dtos.TransaccionDTO;
import com.finsafe.backend.models.Transaccion;
import com.finsafe.backend.models.Usuario;
import com.finsafe.backend.repositories.TransaccionRepository;
import com.finsafe.backend.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService {

    
    private final TransaccionRepository transaccionRepository;
    private final UsuarioRepository usuarioRepository;

    public TransaccionService(TransaccionRepository transaccionRepository, UsuarioRepository usuarioRepository) {
        this.transaccionRepository = transaccionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Registrar un nuevo ingreso o gasto
    public Transaccion registrarTransaccion(Long usuarioId, TransaccionDTO dto) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Transaccion transaccion = new Transaccion();
        transaccion.setValor(dto.getValor());
        transaccion.setDescripcion(dto.getDescripcion());
        transaccion.setFecha(dto.getFecha());
        transaccion.setTipo(dto.getTipo());
        transaccion.setCategoria(dto.getCategoria());
        transaccion.setUsuario(usuario);

        return transaccionRepository.save(transaccion);
    }
    
    // Consultar las transacciones propias
    public List<Transaccion> obtenerTransaccionesPorUsuario(Long usuarioId) {
        return transaccionRepository.findByUsuarioId(usuarioId);
    }
}