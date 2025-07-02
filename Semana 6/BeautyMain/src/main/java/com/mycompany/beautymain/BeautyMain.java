package com.mycompany.beautymain;

// Clase principal que une HERENCIA, POLIMORFISMO y ENCAPSULACIÓN en el contexto de skincare
public class BeautyMain {
    public static void main(String[] args) {
        // Herencia y Polimorfismo:
        SerumFacial miSerum = new SerumFacial("Vitamin C Glow Serum", 45.99, "Vitamin C");
        miSerum.usar();  // Polimorfismo: se ejecuta el método sobrescrito en SerumFacial
        miSerum.mostrarBeneficios();

        // Encapsulación:
        CarritoDeCompras miCarrito = new CarritoDeCompras();
        miCarrito.añadirProducto(miSerum);  // Añade el serum al carrito
        System.out.println("Total en el carrito: $" + miCarrito.getTotal());
    }
}
