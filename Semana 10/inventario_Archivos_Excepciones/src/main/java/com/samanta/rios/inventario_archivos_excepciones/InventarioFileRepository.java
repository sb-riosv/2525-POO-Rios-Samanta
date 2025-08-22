/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samanta.rios.inventario_archivos_excepciones;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

/**
 * Persiste y carga el inventario en un archivo CSV (UTF-8).
 */
public class InventarioFileRepository {

    private final Path rutaArchivo;
    private final GestorDeArchivo gestor;

    public InventarioFileRepository(Path rutaArchivo, GestorDeArchivo gestor) {
        this.rutaArchivo = rutaArchivo;
        this.gestor = gestor;
    }

    public Inventario cargar() throws IOException {
        if (Files.notExists(rutaArchivo)) {
            gestor.asegurarArchivo(rutaArchivo);
            try (var w = Files.newBufferedWriter(rutaArchivo, StandardCharsets.UTF_8,
                    StandardOpenOption.TRUNCATE_EXISTING)) {
                w.write("id,nombre,cantidad,precio\n");
            }
            return new Inventario();
        }

        List<String> lineas = gestor.leerLineas(rutaArchivo);
        Inventario inv = new Inventario();

        if (lineas.size() <= 1) return inv; // solo encabezado o vacío

        for (int i = 1; i < lineas.size(); i++) {
            String l = lineas.get(i);
            if (l == null || l.trim().isEmpty()) continue;
            try {
                Producto p = Producto.fromCsv(l, i + 1);
                inv.agregar(p);
            } catch (IllegalArgumentException e) {
                System.err.println("⚠ Línea ignorada: " + e.getMessage());
            }
        }
        return inv;
    }

    public void guardarTodo(Inventario inv) throws IOException {
        gestor.asegurarArchivo(rutaArchivo);
        try (var w = Files.newBufferedWriter(rutaArchivo, StandardCharsets.UTF_8,
                StandardOpenOption.TRUNCATE_EXISTING)) {
            w.write("id,nombre,cantidad,precio\n");
            for (Producto p : inv.listar()) {
                w.write(p.toCsv());
                w.write("\n");
            }
        }
    }
}
