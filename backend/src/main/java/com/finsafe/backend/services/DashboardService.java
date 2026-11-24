package com.finsafe.backend.services;

import com.finsafe.backend.dtos.CategoriaResumenDTO;
import com.finsafe.backend.dtos.DashboardResumenDTO;
import com.finsafe.backend.models.Transaccion;
import com.finsafe.backend.models.Usuario;
import com.finsafe.backend.repositories.TransaccionRepository;
import com.finsafe.backend.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class DashboardService {

    private final TransaccionRepository transaccionRepository;
    private final UsuarioRepository usuarioRepository;

    public DashboardService(TransaccionRepository transaccionRepository, UsuarioRepository usuarioRepository) {
        this.transaccionRepository = transaccionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public DashboardResumenDTO obtenerResumenUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Transaccion> transacciones = transaccionRepository.findByUsuarioId(usuarioId);

        BigDecimal totalIngresos = BigDecimal.ZERO;
        BigDecimal totalGastos = BigDecimal.ZERO;
        Map<String, BigDecimal> gastosPorCategoria = new HashMap<>();

        for (Transaccion t : transacciones) {
            if ("INGRESO".equalsIgnoreCase(String.valueOf(t.getTipo()))) {
                totalIngresos = totalIngresos.add(t.getValor());
            } else {
                totalGastos = totalGastos.add(t.getValor());
                String nombreCategoria = String.valueOf(t.getCategoria());
                gastosPorCategoria.put(
                        nombreCategoria,
                        gastosPorCategoria.getOrDefault(nombreCategoria, BigDecimal.ZERO).add(t.getValor())
                );
            }
        }

        BigDecimal balanceGeneral = totalIngresos.subtract(totalGastos);

        List<CategoriaResumenDTO> listaCategorias = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : gastosPorCategoria.entrySet()) {
            double porcentaje = 0.0;
            if (totalGastos.compareTo(BigDecimal.ZERO) > 0) {
                porcentaje = entry.getValue()
                        .multiply(BigDecimal.valueOf(100))
                        .divide(totalGastos, 2, RoundingMode.HALF_UP)
                        .doubleValue();
            }
            listaCategorias.add(new CategoriaResumenDTO(entry.getKey(), entry.getValue(), porcentaje));
        }

        // Ordenar categorías de mayor a menor gasto
        listaCategorias.sort((a, b) -> b.getTotal().compareTo(a.getTotal()));

        return new DashboardResumenDTO(
                usuario.getId(),
                usuario.getNombre(),
                totalIngresos,
                totalGastos,
                balanceGeneral,
                transacciones.size(),
                listaCategorias
        );
    }
}