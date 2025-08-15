/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samanta.rios.archivos_excepciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Realiza validaciones sobre archivos de texto.
 * Aquí verificamos que el archivo NO esté vacío.
 */
public class ValidadorArchivo {

    /**
     * Verifica que el archivo no esté vacío.
     * Considera "vacío" si no hay líneas o si todas las líneas son espacios en blanco.
     *
     * @param nombreArchivo nombre o ruta del archivo a validar
     * @throws IOException si no se puede abrir/leer el archivo
     * @throws ArchivoVacioException si el archivo no contiene contenido útil
     */
    public void verificarNoVacio(String nombreArchivo) throws IOException, ArchivoVacioException {
        boolean tieneContenido = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    tieneContenido = true;
                    break;
                }
            }
        }

        if (!tieneContenido) {
            throw new ArchivoVacioException("El archivo '" + nombreArchivo + "' está vacío.");
        }
    }
}

