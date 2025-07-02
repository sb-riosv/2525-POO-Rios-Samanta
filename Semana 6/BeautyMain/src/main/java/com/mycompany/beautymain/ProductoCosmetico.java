package com.mycompany.beautymain;

// Clase base que representa un producto cosmético genérico (HERENCIA)
public class ProductoCosmetico {
    protected String nombre;  // Nombre del producto
    protected double precio;  // Precio del producto

    // Constructor para inicializar atributos comunes
    public ProductoCosmetico(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Método genérico para usar el producto, será sobrescrito por clases hijas → POLIMORFISMO
    public void usar() {
        System.out.println("Usando el producto cosmetico: " + nombre);
    }
}
