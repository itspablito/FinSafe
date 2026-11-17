package com.finsafe.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Deshabilitar CSRF (común en APIs REST)
            .csrf(csrf -> csrf.disable())
            
            // Configurar el manejo de sesiones como sin estado (para futuro uso de JWT)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            
            // Configurar los permisos de las rutas
            .authorizeHttpRequests(auth -> auth
                // Permitir acceso público a la ruta de registro (FIN-1)
                .requestMatchers("/api/usuarios/**", "/error", "/api/presupuestos/**").permitAll()
                .requestMatchers(org.springframework.http.HttpMethod.POST, "/api/transacciones/usuario/*").permitAll()
                .requestMatchers(org.springframework.http.HttpMethod.GET, "/api/transacciones/usuario/*").permitAll()
                // Cualquier otra ruta requerirá autenticación
                .anyRequest().authenticated()
            );
            
        return http.build();
    }
}