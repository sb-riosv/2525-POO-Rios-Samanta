package com.mycompany.ejemplosmundoreal_poo;

import java.util.*;

// Clase principal con el método main
public class TiendaFacialApp {
    public static void main(String[] args) {
        System.out.println("Bienvenido a la tienda de cuidado facial\n");

        // Crear productos
        ProductoFacial crema = new ProductoFacial("Crema hidratante", 12.50, "Seca", 10);
        ProductoFacial tonico = new ProductoFacial("Tónico refrescante", 8.75, "Grasa", 5);
        ProductoFacial serum = new ProductoFacial("Serum antioxidante", 18.00, "Mixta", 3);

        // Crear cliente
        Cliente cliente = new Cliente("Samantha", "samantha@email.com", "Mixta");

        // Crear carrito y agregar productos
        CarritoDeCompras carrito = new CarritoDeCompras();
        carrito.agregarProducto(crema);
        carrito.agregarProducto(serum);

        // Mostrar información
        cliente.mostrarInformacion();
        carrito.mostrarResumen();
    }
}

// Clase que representa un producto de cuidado facial
class ProductoFacial {
    private String nombre;
    private double precio;
    private String tipoDePiel;
    private int stockDisponible;

    public ProductoFacial(String nombre, double precio, String tipoDePiel, int stockDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoDePiel = tipoDePiel;
        this.stockDisponible = stockDisponible;
    }

    public void mostrarInformacion() {
        System.out.println("Producto: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Tipo de piel recomendado: " + tipoDePiel);
        System.out.println("Stock disponible: " + stockDisponible);
        System.out.println("---------------------------");
    }

    public double getPrecio() {
        return precio;
    }
}

// Clase que representa a un cliente
class Cliente {
    private String nombre;
    private String correo;
    private String tipoDePiel;

    public Cliente(String nombre, String correo, String tipoDePiel) {
        this.nombre = nombre;
        this.correo = correo;
        this.tipoDePiel = tipoDePiel;
    }

    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Tipo de piel: " + tipoDePiel);
        System.out.println("---------------------------");
    }
}

// Clase que representa un carrito de compras
class CarritoDeCompras {
    private List<ProductoFacial> productos;

    public CarritoDeCompras() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(ProductoFacial producto) {
        productos.add(producto);
    }

    public void mostrarResumen() {
        System.out.println("\nResumen del carrito:");
        for (ProductoFacial p : productos) {
            p.mostrarInformacion();
        }
        System.out.println("Total a pagar: $" + calcularTotal());
        System.out.println("==========================");
    }

    public double calcularTotal() {
        double total = 0;
        for (ProductoFacial p : productos) {
            total += p.getPrecio();
        }
        return total;
    }
}
