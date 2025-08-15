/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samanta.rios.archivos_excepciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de servicio responsable de la lectura y escritura de archivos de texto.
 * Encapsula las operaciones de I/O (Single Responsibility Principle).
 */
public class GestorDeArchivo {

    /**
     * Escribe el contenido recibido en el archivo indicado. Si no existe, lo crea.
     * Sobrescribe el contenido anterior.
     *
     * @param nombreArchivo nombre o ruta del archivo (p. ej., "frasesMotivacionales.txt")
     * @param contenido     texto a escribir (puede ser multilínea)
     * @throws IOException si ocurre un error de entrada/salida
     */
    public void guardar(String nombreArchivo, String contenido) throws IOException {
        // try-with-resources asegura cerrar el escritor automáticamente
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(contenido);
            writer.flush();
        }
    }

    /**
     * Lee el archivo línea por línea y devuelve todas las líneas en una lista.
     *
     * @param nombreArchivo nombre o ruta del archivo a leer
     * @return lista con las líneas en el mismo orden del archivo
     * @throws IOException si el archivo no existe o no se puede leer
     */
    public List<String> leer(String nombreArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();
        // try-with-resources asegura cerrar el lector automáticamente
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }
}

