package com.finsafe.backend.repositories;

import com.finsafe.backend.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    Optional<Grupo> findByCodigoInvitacion(String codigoInvitacion);
    List<Grupo> findByIntegrantesId(Long usuarioId);
}