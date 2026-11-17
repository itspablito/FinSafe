package com.finsafe.backend.services;

import com.finsafe.backend.dtos.PresupuestoDTO;
import com.finsafe.backend.dtos.PresupuestoRespuestaDTO;
import com.finsafe.backend.models.Presupuesto;
import com.finsafe.backend.models.Transaccion;
import com.finsafe.backend.models.Usuario;
import com.finsafe.backend.repositories.PresupuestoRepository;
import com.finsafe.backend.repositories.TransaccionRepository;
import com.finsafe.backend.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PresupuestoService {

    private final PresupuestoRepository presupuestoRepository;
    private final TransaccionRepository transaccionRepository;
    private final UsuarioRepository usuarioRepository;

    public PresupuestoService(PresupuestoRepository presupuestoRepository, 
                              TransaccionRepository transaccionRepository, 
                              UsuarioRepository usuarioRepository) {
        this.presupuestoRepository = presupuestoRepository;
        this.transaccionRepository = transaccionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Método para configurar o actualizar el presupuesto
    public PresupuestoRespuestaDTO configurarPresupuesto(Long usuarioId, PresupuestoDTO dto) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Busca si ya existe un presupuesto para ese mes/año. Si existe lo actualiza, si no, lo crea.
        Presupuesto presupuesto = presupuestoRepository
                .findByUsuarioIdAndMesAndAnio(usuarioId, dto.getMes(), dto.getAnio())
                .orElse(new Presupuesto());

        presupuesto.setMes(dto.getMes());
        presupuesto.setAnio(dto.getAnio());
        presupuesto.setLimite(dto.getLimite());
        presupuesto.setUsuario(usuario);
        
        presupuestoRepository.save(presupuesto);

        return obtenerResumenPresupuesto(usuarioId, dto.getMes(), dto.getAnio());
    }

    // Método para consultar el resumen (Límite, Gasto y Saldo)
    public PresupuestoRespuestaDTO obtenerResumenPresupuesto(Long usuarioId, Integer mes, Integer anio) {
        Optional<Presupuesto> presupuestoOpt = presupuestoRepository.findByUsuarioIdAndMesAndAnio(usuarioId, mes, anio);
        
        // Si no hay presupuesto configurado, cumplimos el criterio de la EDT devolviendo un error controlado
        if (presupuestoOpt.isEmpty()) {
            throw new RuntimeException("No existe un presupuesto configurado para el periodo seleccionado");
        }

        Presupuesto presupuesto = presupuestoOpt.get();

        // Obtener todas las transacciones del usuario
        List<Transaccion> transacciones = transaccionRepository.findByUsuarioId(usuarioId);

        // Filtrar y sumar solo los "GASTOS" que coincidan con el mes y año solicitados
        BigDecimal gastoAcumulado = transacciones.stream()
                .filter(t -> t.getTipo().equalsIgnoreCase("GASTO"))
                .filter(t -> t.getFecha().getMonthValue() == mes && t.getFecha().getYear() == anio)
                .map(Transaccion::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Calcular el saldo disponible
        BigDecimal saldoDisponible = presupuesto.getLimite().subtract(gastoAcumulado);

        // Armar la respuesta
        PresupuestoRespuestaDTO respuesta = new PresupuestoRespuestaDTO();
        respuesta.setMes(mes);
        respuesta.setAnio(anio);
        respuesta.setLimite(presupuesto.getLimite());
        respuesta.setGastoAcumulado(gastoAcumulado);
        respuesta.setSaldoDisponible(saldoDisponible);

        return respuesta;
    }
}