package com.finsafe.backend.controllers;

import com.finsafe.backend.services.ExportacionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exportar")
public class ExportacionController {

    private final ExportacionService exportacionService;

    public ExportacionController(ExportacionService exportacionService) {
        this.exportacionService = exportacionService;
    }

    // GET: /api/exportar/csv/usuario/1
    @GetMapping("/csv/usuario/{usuarioId}")
    public ResponseEntity<?> exportarCsv(@PathVariable Long usuarioId) {
        try {
            byte[] archivoCsv = exportacionService.generarCsvUsuario(usuarioId);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("text/csv; charset=UTF-8"));
            headers.setContentDispositionFormData("attachment", "reporte_finsafe_usuario_" + usuarioId + ".csv");

            return new ResponseEntity<>(archivoCsv, headers, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // GET: /api/exportar/pdf/usuario/1
    @GetMapping("/pdf/usuario/{usuarioId}")
    public ResponseEntity<?> exportarPdf(@PathVariable Long usuarioId) {
        try {
            byte[] archivoPdf = exportacionService.generarPdfUsuario(usuarioId);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "reporte_finsafe_usuario_" + usuarioId + ".pdf");

            return new ResponseEntity<>(archivoPdf, headers, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}