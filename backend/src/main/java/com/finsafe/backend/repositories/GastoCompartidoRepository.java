package com.finsafe.backend.repositories;

import com.finsafe.backend.models.GastoCompartido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GastoCompartidoRepository extends JpaRepository<GastoCompartido, Long> {
    List<GastoCompartido> findByGrupoIdOrderByFechaDesc(Long grupoId);
}