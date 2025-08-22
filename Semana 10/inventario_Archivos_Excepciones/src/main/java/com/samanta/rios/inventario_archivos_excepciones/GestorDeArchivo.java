/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samanta.rios.inventario_archivos_excepciones;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de servicio responsable de la lectura y escritura de archivos de texto (UTF-8).
 * Encapsula las operaciones de I/O.
 */
public class GestorDeArchivo {

    /**
     * Crea el archivo y sus directorios padres si no existen.
     */
    public void asegurarArchivo(Path ruta) throws IOException {
        Path parent = ruta.getParent();
        if (parent != null && !Files.exists(parent)) {
            Files.createDirectories(parent);
        }
        if (!Files.exists(ruta)) {
            Files.createFile(ruta);
        }
    }

    /**
     * Escribe (sobrescribe) el contenido recibido en el archivo indicado (UTF-8).
     */
    public void guardarString(Path ruta, String contenido) throws IOException {
        asegurarArchivo(ruta);
        try (var writer = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8,
                StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write(contenido);
        }
    }

    /**
     * Lee el archivo línea por línea (UTF-8) y devuelve todas las líneas en una lista.
     */
    public List<String> leerLineas(Path ruta) throws IOException {
        List<String> lineas = new ArrayList<>();
        try (var reader = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }
}
