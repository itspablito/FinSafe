package com.finsafe.backend.repositories;

import com.finsafe.backend.models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    
    // Spring Data JPA crea automáticamente la consulta SQL con solo nombrar el método así
    List<Transaccion> findByUsuarioId(Long usuarioId);
}