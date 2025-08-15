/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.samanta.rios.archivos_excepciones;

import java.io.IOException;
import java.util.List;

/**
 * Demostración de:
 * - guardar() -> escribir archivo
 * - leer() -> leer línea por línea
 * - verificarNoVacio() -> lanzar excepción si está vacío
 * Con manejo de excepciones vía try-catch.
 * Tema: Frases motivacionales.
 */
public class Main {

    public static void main(String[] args) {
        // Archivo principal de trabajo
        String archivo = "frasesMotivacionales.txt";

        // Contenido con frases motivacionales
        String contenido = "Frases motivadoras:\n"
                + "- Cree en ti mismo.\n"
                + "- El esfuerzo vence al talento.\n"
                + "- Nunca es tarde para aprender.\n"
                + "- Cada dia cuenta.";

        // Instancias de las clases solicitadas
        GestorDeArchivo gestor = new GestorDeArchivo();
        ValidadorArchivo validador = new ValidadorArchivo();

        try {
            // 1) Guardar contenido en el archivo principal
            gestor.guardar(archivo, contenido);
            System.out.println("Contenido guardado en " + archivo);

            // 2) Verificar que el archivo principal no esté vacío
            validador.verificarNoVacio(archivo);

            // 3) Leer el contenido línea por línea y mostrarlo con numeración
            List<String> lineas = gestor.leer(archivo);
            System.out.println("\nContenido leido del archivo:");
            int contador = 1;
            for (String l : lineas) {
                System.out.println(" " + contador + ". " + l);
                contador++;
            }

            System.out.println("\nArchivo verificado: contiene informacion.");

            // === Segundo test: probar archivo vacío para provocar ArchivoVacioException ===
            String archivoVacio = "archivoVacio.txt";
            gestor.guardar(archivoVacio, ""); // Guardar un archivo sin contenido
            validador.verificarNoVacio(archivoVacio); // Esto lanzará la excepción

        } catch (ArchivoVacioException ave) {
            // Captura la excepción personalizada cuando el archivo está vacío
            System.err.println("Error: el archivo no contiene datos.");
        } catch (IOException ioe) {
            // Captura errores de entrada/salida
            System.err.println("Error de IO: " + ioe.getMessage());
        } finally {
            System.out.println("\nProceso finalizado.");
        }
    }
}
