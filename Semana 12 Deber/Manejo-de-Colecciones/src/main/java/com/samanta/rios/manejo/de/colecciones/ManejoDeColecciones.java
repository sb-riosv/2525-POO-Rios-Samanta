/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.samanta.rios.manejo.de.colecciones;

public class ManejoDeColecciones {
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();

        // Registrar usuarios
        b.registrarUsuario(new Usuario("U1", "Samantha"));
        b.registrarUsuario(new Usuario("U2", "Briggitte"));

        // Añadir libros
        b.añadirLibro(new Libro("ISBN-010", "Clean Code", "Robert C. Martin", "Software"));
        b.añadirLibro(new Libro("ISBN-002", "Effective Java", "Joshua Bloch", "Java"));

        // Prestar libros
        b.prestarLibro("U1", "ISBN-010");
        b.prestarLibro("U2", "ISBN-002");

        // Listar prestados de U1
        System.out.println("Prestados de U1:");
        b.listarPrestados("U1").forEach(System.out::println);

        // Devolver un libro
        b.devolverLibro("U1", "ISBN-010");

        // Búsquedas
        System.out.println("\nBuscar por autor 'Bloch':");
        b.buscarPorAutor("Bloch").forEach(System.out::println);

        System.out.println("\nBuscar por categoria 'Software':");
        b.buscarPorCategoria("Software").forEach(System.out::println);

        // Validaciones
        try {
            System.out.println("\nIntento de doble prestamo ISBN-002 a U1:");
            b.prestarLibro("U1", "ISBN-002");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nIntento de quitar ISBN-002 (prestado):");
            System.out.println("Quitado? " + b.quitarLibro("ISBN-002"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        b.devolverLibro("U2", "ISBN-002");
        System.out.println("\nQuitar ISBN-002 luego de devolver:");
        System.out.println("Quitado? " + b.quitarLibro("ISBN-002"));

        try {
            System.out.println("\nDar de baja U2:");
            System.out.println("Baja exitosa? " + b.darBajaUsuario("U2"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nBuscar por titulo 'Clean':");
        b.buscarPorTitulo("Clean").forEach(System.out::println);
    }
}
