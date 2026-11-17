package com.finsafe.backend.repositories;

import com.finsafe.backend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Spring Boot leerá esto y ejecutará: SELECT * FROM usuarios WHERE correo_electronico = ?
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);
    
    // Spring Boot leerá esto y devolverá true o false si el correo existe
    boolean existsByCorreoElectronico(String correoElectronico);
}