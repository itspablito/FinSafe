package com.finsafe.backend.services;

import com.finsafe.backend.dtos.CrearGastoCompartidoDTO;
import com.finsafe.backend.dtos.DetalleDistribucionDTO;
import com.finsafe.backend.dtos.BalanceGrupoDTO;
import com.finsafe.backend.dtos.DeudaSimplificadaDTO;
import com.finsafe.backend.dtos.SaldoParticipanteDTO;
import com.finsafe.backend.enums.TipoDistribucion;
import com.finsafe.backend.models.DetalleGastoCompartido;
import com.finsafe.backend.models.GastoCompartido;
import com.finsafe.backend.models.Grupo;
import com.finsafe.backend.models.Usuario;
import com.finsafe.backend.repositories.GastoCompartidoRepository;
import com.finsafe.backend.repositories.GrupoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

@Service
public class GastoCompartidoService {

    private final GastoCompartidoRepository gastoCompartidoRepository;
    private final GrupoRepository grupoRepository;

    public GastoCompartidoService(GastoCompartidoRepository gastoCompartidoRepository, GrupoRepository grupoRepository) {
        this.gastoCompartidoRepository = gastoCompartidoRepository;
        this.grupoRepository = grupoRepository;
    }

    @Transactional
    public GastoCompartido registrarGastoCompartido(Long grupoId, Long usuarioSolicitanteId, CrearGastoCompartidoDTO dto) {
        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        Set<Usuario> integrantes = grupo.getIntegrantes();

        // 1. Validar que quien registra el gasto pertenezca al grupo
        boolean solicitantePertenece = integrantes.stream()
                .anyMatch(u -> u.getId().equals(usuarioSolicitanteId));
        if (!solicitantePertenece) {
            throw new RuntimeException("Acceso denegado: No perteneces a este grupo");
        }

        // 2. Validar que el usuario que pagó pertenezca al grupo
        Usuario pagador = integrantes.stream()
                .filter(u -> u.getId().equals(dto.getPagadorId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("El usuario pagador no pertenece a este grupo"));

        GastoCompartido gasto = new GastoCompartido();
        gasto.setDescripcion(dto.getDescripcion());
        gasto.setMontoTotal(dto.getMontoTotal());
        gasto.setFecha(dto.getFecha());
        gasto.setTipoDistribucion(dto.getTipoDistribucion());
        gasto.setGrupo(grupo);
        gasto.setPagador(pagador);

        List<DetalleGastoCompartido> listaDetalles = new ArrayList<>();

        // 3. Calcular distribución según el tipo elegido
        if (dto.getTipoDistribucion() == TipoDistribucion.PARTES_IGUALES) {
            int totalIntegrantes = integrantes.size();
            BigDecimal cantidad = BigDecimal.valueOf(totalIntegrantes);
            BigDecimal cuotaBase = dto.getMontoTotal().divide(cantidad, 2, RoundingMode.DOWN);
            BigDecimal residuo = dto.getMontoTotal().subtract(cuotaBase.multiply(cantidad));

            int indice = 0;
            for (Usuario integrante : integrantes) {
                DetalleGastoCompartido detalle = new DetalleGastoCompartido();
                detalle.setGastoCompartido(gasto);
                detalle.setUsuario(integrante);
                
                // Si hay centavos sobrantes (ej. 100 / 3 = 33.33 + 0.01), se suman al primer integrante
                BigDecimal montoFinal = (indice == 0) ? cuotaBase.add(residuo) : cuotaBase;
                detalle.setMontoAsignado(montoFinal);
                listaDetalles.add(detalle);
                indice++;
            }

        } else if (dto.getTipoDistribucion() == TipoDistribucion.MONTOS_EXACTOS) {
            if (dto.getDetalles() == null || dto.getDetalles().isEmpty()) {
                throw new RuntimeException("Debe especificar el detalle de montos por integrante para distribución exacta");
            }

            BigDecimal sumaDetalles = BigDecimal.ZERO;

            for (DetalleDistribucionDTO item : dto.getDetalles()) {
                Usuario participante = integrantes.stream()
                        .filter(u -> u.getId().equals(item.getUsuarioId()))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("El usuario con ID " + item.getUsuarioId() + " no pertenece al grupo"));

                DetalleGastoCompartido detalle = new DetalleGastoCompartido();
                detalle.setGastoCompartido(gasto);
                detalle.setUsuario(participante);
                detalle.setMontoAsignado(item.getMonto());
                listaDetalles.add(detalle);

                sumaDetalles = sumaDetalles.add(item.getMonto());
            }

            // Validar que la suma de los montos individuales sea exactamente igual al montoTotal
            if (sumaDetalles.compareTo(dto.getMontoTotal()) != 0) {
                throw new RuntimeException("La suma de los montos asignados (" + sumaDetalles + ") no coincide con el monto total (" + dto.getMontoTotal() + ")");
            }
        }

        gasto.setDistribucion(listaDetalles);
        return gastoCompartidoRepository.save(gasto);
    }

    public List<GastoCompartido> obtenerHistorialGrupo(Long grupoId, Long usuarioSolicitanteId) {
        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        boolean pertenece = grupo.getIntegrantes().stream()
                .anyMatch(u -> u.getId().equals(usuarioSolicitanteId));

        if (!pertenece) {
            throw new RuntimeException("Acceso denegado: No perteneces a este grupo");
        }

        return gastoCompartidoRepository.findByGrupoIdOrderByFechaDesc(grupoId);
    }

    public BalanceGrupoDTO calcularBalancesGrupo(Long grupoId, Long usuarioSolicitanteId) {
        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        boolean pertenece = grupo.getIntegrantes().stream()
                .anyMatch(u -> u.getId().equals(usuarioSolicitanteId));

        if (!pertenece) {
            throw new RuntimeException("Acceso denegado: No perteneces a este grupo");
        }

        List<GastoCompartido> gastos = gastoCompartidoRepository.findByGrupoIdOrderByFechaDesc(grupoId);

        Map<Long, BigDecimal> pagadoPorUsuario = new HashMap<>();
        Map<Long, BigDecimal> consumidoPorUsuario = new HashMap<>();

        for (Usuario integrante : grupo.getIntegrantes()) {
            pagadoPorUsuario.put(integrante.getId(), BigDecimal.ZERO);
            consumidoPorUsuario.put(integrante.getId(), BigDecimal.ZERO);
        }

        BigDecimal gastoTotalGrupo = BigDecimal.ZERO;

        for (GastoCompartido gasto : gastos) {
            gastoTotalGrupo = gastoTotalGrupo.add(gasto.getMontoTotal());
            
            Long pagadorId = gasto.getPagador().getId();
            pagadoPorUsuario.put(pagadorId, pagadoPorUsuario.getOrDefault(pagadorId, BigDecimal.ZERO).add(gasto.getMontoTotal()));

            for (DetalleGastoCompartido detalle : gasto.getDistribucion()) {
                Long consumidorId = detalle.getUsuario().getId();
                consumidoPorUsuario.put(consumidorId, consumidoPorUsuario.getOrDefault(consumidorId, BigDecimal.ZERO).add(detalle.getMontoAsignado()));
            }
        }

        List<SaldoParticipanteDTO> saldosIndividuales = new ArrayList<>();
        // Listas auxiliares mutables para cruzar deudores contra acreedores
        List<Object[]> deudores = new ArrayList<>();
        List<Object[]> acreedores = new ArrayList<>();

        for (Usuario integrante : grupo.getIntegrantes()) {
            Long id = integrante.getId();
            BigDecimal pagado = pagadoPorUsuario.get(id);
            BigDecimal consumido = consumidoPorUsuario.get(id);
            BigDecimal neto = pagado.subtract(consumido);

            saldosIndividuales.add(new SaldoParticipanteDTO(id, integrante.getNombre(), pagado, consumido, neto));

            if (neto.compareTo(BigDecimal.ZERO) < 0) {
                deudores.add(new Object[]{id, integrante.getNombre(), neto.abs()});
            } else if (neto.compareTo(BigDecimal.ZERO) > 0) {
                acreedores.add(new Object[]{id, integrante.getNombre(), neto});
            }
        }

        // Algoritmo de compensación de deudas (Greedy)
        List<DeudaSimplificadaDTO> liquidacion = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < deudores.size() && j < acreedores.size()) {
            Object[] deudor = deudores.get(i);
            Object[] acreedor = acreedores.get(j);

            BigDecimal deudaPendiente = (BigDecimal) deudor[2];
            BigDecimal saldoAFavor = (BigDecimal) acreedor[2];

            BigDecimal montoTransferencia = deudaPendiente.min(saldoAFavor);

            liquidacion.add(new DeudaSimplificadaDTO(
                    (Long) deudor[0], (String) deudor[1],
                    (Long) acreedor[0], (String) acreedor[1],
                    montoTransferencia
            ));

            BigDecimal nuevaDeuda = deudaPendiente.subtract(montoTransferencia);
            BigDecimal nuevoSaldo = saldoAFavor.subtract(montoTransferencia);

            deudor[2] = nuevaDeuda;
            acreedor[2] = nuevoSaldo;

            if (nuevaDeuda.compareTo(BigDecimal.ZERO) == 0) i++;
            if (nuevoSaldo.compareTo(BigDecimal.ZERO) == 0) j++;
        }

        return new BalanceGrupoDTO(grupo.getId(), grupo.getNombre(), gastoTotalGrupo, saldosIndividuales, liquidacion);
    }

}