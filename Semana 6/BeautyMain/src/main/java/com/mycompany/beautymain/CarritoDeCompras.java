package com.mycompany.beautymain;

// Clase que demuestra ENCAPSULACIÓN al proteger el atributo total
public class CarritoDeCompras {
    private double total;  // Atributo encapsulado, solo accesible desde la propia clase

    // Constructor que inicializa el total del carrito en cero
    public CarritoDeCompras() {
        this.total = 0.0;
    }

    // Método público para añadir un producto al carrito, actualizando el total de forma controlada
    public void añadirProducto(ProductoCosmetico producto) {
        total += producto.precio;
        System.out.println("Producto agregado: " + producto.nombre + " - Precio: $" + producto.precio);
    }

    // Método getter para consultar el total actual del carrito → acceso controlado al atributo privado
    public double getTotal() {
        return total;
    }
}
