package com.finsafe.backend.repositories;

import com.finsafe.backend.models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    
    // Spring Data JPA crea automáticamente la consulta SQL con solo nombrar el método así
    List<Transaccion> findByUsuarioId(Long usuarioId);
}