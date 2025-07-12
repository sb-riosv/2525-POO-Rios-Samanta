/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.programasuscripcionmensual;

/**
 *
 * @author Usuario
 */
public class ProgramaSuscripcionMensual {
    public static void main(String[] args) {

        // Crear un cliente con constructor parametrizado
        Cliente cliente1 = new Cliente("Samanta Rios", "sriosvivanco@gmail.com", "0987654321", "rizado");

        // Crear productos capilares usando diferentes constructores
        ProductoCapilar producto1 = new ProductoCapilar("Shampoo Hidratante", "Shampoo", "cabello seco", 12.50);
        ProductoCapilar producto2 = new ProductoCapilar("Mascarilla Reparadora", "Mascarilla");
        ProductoCapilar producto3 = new ProductoCapilar(); // producto genérico

        // Crear un array de productos
        ProductoCapilar[] productos = { producto1, producto2, producto3 };

        // Crear una suscripción usando constructor parametrizado
        SuscripcionCapilar suscripcion1 = new SuscripcionCapilar(cliente1, productos, "mensual", 24.99, true);

        // Mostrar detalles de la suscripción
        System.out.println("=== Detalles de la Suscripcion ===");
        suscripcion1.mostrarDetalles();

        // Crear otra suscripción con sobrecarga (sin productos)
        SuscripcionCapilar suscripcion2 = new SuscripcionCapilar(cliente1, "bimensual", 15.99);

        System.out.println("\n=== Segunda Suscripcion ===");
        suscripcion2.mostrarDetalles();
    }
}
