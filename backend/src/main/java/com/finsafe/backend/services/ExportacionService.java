package com.finsafe.backend.services;

import com.finsafe.backend.models.Transaccion;
import com.finsafe.backend.models.Usuario;
import com.finsafe.backend.repositories.TransaccionRepository;
import com.finsafe.backend.repositories.UsuarioRepository;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class ExportacionService {

    private final TransaccionRepository transaccionRepository;
    private final UsuarioRepository usuarioRepository;

    public ExportacionService(TransaccionRepository transaccionRepository, UsuarioRepository usuarioRepository) {
        this.transaccionRepository = transaccionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public byte[] generarCsvUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Transaccion> transacciones = transaccionRepository.findByUsuarioId(usuario.getId());

        StringBuilder csv = new StringBuilder();
        // Cabecera del archivo CSV
        csv.append("ID,Fecha,Tipo,Categoria,Descripcion,Monto\n");

        for (Transaccion t : transacciones) {
            String descripcionLimpia = t.getDescripcion() != null 
                    ? t.getDescripcion().replace(",", " ").replace("\n", " ") 
                    : "";
            
            csv.append(t.getId()).append(",")
               .append(t.getFecha()).append(",")
               .append(t.getTipo()).append(",")
               .append(t.getCategoria()).append(",")
               .append(descripcionLimpia).append(",")
               .append(t.getValor()).append("\n");
        }

        // Agregamos BOM UTF-8 para que Excel abra tildes y caracteres especiales sin errores
        byte[] bom = new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
        byte[] contenido = csv.toString().getBytes(StandardCharsets.UTF_8);
        byte[] resultado = new byte[bom.length + contenido.length];
        System.arraycopy(bom, 0, resultado, 0, bom.length);
        System.arraycopy(contenido, 0, resultado, bom.length, contenido.length);

        return resultado;
    }

    public byte[] generarPdfUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Transaccion> transacciones = transaccionRepository.findByUsuarioId(usuario.getId());

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, out);
            document.open();

            // Título y datos del usuario
            Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, new Color(33, 37, 41));
            Paragraph titulo = new Paragraph("FinSafe - Reporte Financiero Personal", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(10);
            document.add(titulo);

            Font fontSubtitulo = FontFactory.getFont(FontFactory.HELVETICA, 11, Color.DARK_GRAY);
            document.add(new Paragraph("Usuario: " + usuario.getNombre(), fontSubtitulo));
            document.add(new Paragraph("Correo: " + usuario.getCorreoElectronico(), fontSubtitulo));
            document.add(new Paragraph("Total de movimientos registrados: " + transacciones.size(), fontSubtitulo));
            document.add(Chunk.NEWLINE);

            // Tabla de transacciones
            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{2f, 2f, 2.5f, 4f, 2f});

            String[] columnas = {"Fecha", "Tipo", "Categoría", "Descripción", "Monto"};
            Font fontCabecera = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, Color.WHITE);

            for (String col : columnas) {
                PdfPCell celda = new PdfPCell(new Phrase(col, fontCabecera));
                celda.setBackgroundColor(new Color(41, 128, 185));
                celda.setPadding(6);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda);
            }

            Font fontFila = FontFactory.getFont(FontFactory.HELVETICA, 9, Color.BLACK);
            BigDecimal totalIngresos = BigDecimal.ZERO;
            BigDecimal totalGastos = BigDecimal.ZERO;

            for (Transaccion t : transacciones) {
                tabla.addCell(new PdfPCell(new Phrase(String.valueOf(t.getFecha()), fontFila)));
                tabla.addCell(new PdfPCell(new Phrase(String.valueOf(t.getTipo()), fontFila)));
                tabla.addCell(new PdfPCell(new Phrase(String.valueOf(t.getCategoria()), fontFila)));
                tabla.addCell(new PdfPCell(new Phrase(t.getDescripcion() != null ? t.getDescripcion() : "", fontFila)));
                
                PdfPCell celdaMonto = new PdfPCell(new Phrase("$" + t.getValor(), fontFila));
                celdaMonto.setHorizontalAlignment(Element.ALIGN_RIGHT);
                tabla.addCell(celdaMonto);

                if ("INGRESO".equalsIgnoreCase(String.valueOf(t.getTipo()))) {
                    totalIngresos = totalIngresos.add(t.getValor());
                } else {
                    totalGastos = totalGastos.add(t.getValor());
                }
            }

            document.add(tabla);
            document.add(Chunk.NEWLINE);

            // Resumen final
            Font fontResumen = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, Color.BLACK);
            document.add(new Paragraph("Total Ingresos: $" + totalIngresos, fontResumen));
            document.add(new Paragraph("Total Gastos: $" + totalGastos, fontResumen));
            document.add(new Paragraph("Balance Neto: $" + totalIngresos.subtract(totalGastos), fontResumen));

            document.close();
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar el reporte PDF: " + e.getMessage());
        }
    }
}