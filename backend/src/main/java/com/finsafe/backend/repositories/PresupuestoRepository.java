package com.finsafe.backend.repositories;

import com.finsafe.backend.models.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface PresupuestoRepository extends JpaRepository<Presupuesto, Long> {
    
    // Busca un presupuesto específico para un usuario, mes y año
    Optional<Presupuesto> findByUsuarioIdAndMesAndAnio(Long usuarioId, Integer mes, Integer anio);
}