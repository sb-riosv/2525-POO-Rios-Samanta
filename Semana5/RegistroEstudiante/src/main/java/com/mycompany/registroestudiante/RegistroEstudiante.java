/*
 * Programa: Registro de calificación de un estudiante
 * Descripción: Este programa registra el nombre, edad y calificación de un estudiante
 * de la Universidad Estatal Amazónica, determina si está aprobado y muestra la información.
 */

package com.mycompany.registroestudiante;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class RegistroEstudiante {
    public static void main(String[] args) {
        // Crear el objeto Scanner para leer datos del teclado
        Scanner input = new Scanner(System.in);

        // Declarar variables usando tipos de datos requeridos
        String nombre_estudiante;
        int edad_estudiante;
        double calificacion_estudiante;
        boolean esta_aprobado;

        // Mensaje de bienvenida
        System.out.println("=== Registro de Estudiante - Universidad Estatal Amazonica ===");

        // Solicitar nombre
        System.out.print("Ingrese el nombre del estudiante: ");
        nombre_estudiante = input.nextLine();

        // Solicitar edad
        System.out.print("Ingrese la edad del estudiante: ");
        edad_estudiante = input.nextInt();

        // Solicitar calificación
        System.out.print("Ingrese la calificacion del estudiante (0 - 10): ");
        calificacion_estudiante = input.nextDouble();

        // Evaluar si está aprobado (calificación mayor o igual a 7.0)
        esta_aprobado = calificacion_estudiante >= 7.0;

        // Mostrar los resultados
        System.out.println("\n=== Resultados del Registro ===");
        System.out.println("Nombre: " + nombre_estudiante);
        System.out.println("Edad: " + edad_estudiante);
        System.out.println("Calificacion: " + calificacion_estudiante);

        if (esta_aprobado) {
            System.out.println("Estado: Aprobado");
        } else {
            System.out.println("Estado: Reprobado");
        }

        // Cerrar el objeto Scanner
        input.close();
    }
}

