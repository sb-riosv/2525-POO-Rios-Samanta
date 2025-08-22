/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samanta.rios.inventario_archivos_excepciones;


/**
 * Excepción personalizada para indicar que un archivo está vacío o sin contenido significativo.
 */
public class ArchivoVacioException extends Exception {
    private static final long serialVersionUID = 1L;

    public ArchivoVacioException() {
        super("El archivo está vacío o no contiene contenido significativo.");
    }

    public ArchivoVacioException(String mensaje) {
        super(mensaje);
    }

    public ArchivoVacioException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public ArchivoVacioException(Throwable causa) {
        super(causa);
    }
}
