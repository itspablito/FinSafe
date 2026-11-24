package com.finsafe.backend.controllers;

import com.finsafe.backend.dtos.DashboardResumenDTO;
import com.finsafe.backend.services.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    // GET: /api/dashboard/usuario/1
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> obtenerDashboard(@PathVariable Long usuarioId) {
        try {
            DashboardResumenDTO resumen = dashboardService.obtenerResumenUsuario(usuarioId);
            return new ResponseEntity<>(resumen, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}