/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samanta.rios.inventario_archivos_excepciones;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * Verifica que un archivo de texto no esté vacío ni solo con blancos.
 */
public class ValidadorArchivo {

    public void verificarNoVacio(Path ruta) throws IOException, ArchivoVacioException {
        if (ruta == null) throw new IllegalArgumentException("ruta no puede ser nula");
        if (Files.notExists(ruta)) throw new java.io.FileNotFoundException("No existe: " + ruta.toString());

        try (var reader = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    return; // tiene contenido útil
                }
            }
        }
        throw new ArchivoVacioException("El archivo '" + ruta.getFileName() + "' está vacío.");
    }
}

