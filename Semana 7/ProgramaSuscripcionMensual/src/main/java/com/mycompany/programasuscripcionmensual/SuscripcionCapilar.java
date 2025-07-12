/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programasuscripcionmensual;

/**
 *
 * @author Usuario
 */
public class SuscripcionCapilar {
    private Cliente cliente;
    private ProductoCapilar[] productos;
    private String frecuencia; // mensual, bimensual, etc.
    private double precioMensual;
    private boolean activo;

    // Constructor por defecto
    public SuscripcionCapilar() {
        this.cliente = new Cliente();
        this.productos = new ProductoCapilar[0];
        this.frecuencia = "mensual";
        this.precioMensual = 19.99;
        this.activo = true;
    }

    // Constructor parametrizado completo
    public SuscripcionCapilar(Cliente cliente, ProductoCapilar[] productos, String frecuencia, double precioMensual, boolean activo) {
        this.cliente = cliente;
        this.productos = productos;
        this.frecuencia = frecuencia;
        this.precioMensual = precioMensual;
        this.activo = activo;
    }

    // Constructor sobrecargado sin productos (lista vacía por defecto)
    public SuscripcionCapilar(Cliente cliente, String frecuencia, double precioMensual) {
        this.cliente = cliente;
        this.productos = new ProductoCapilar[0];
        this.frecuencia = frecuencia;
        this.precioMensual = precioMensual;
        this.activo = true;
    }

    // Método para mostrar los detalles de la suscripción
    public void mostrarDetalles() {
        System.out.println("=== Cliente ===");
        cliente.mostrarDatosCliente();
        
        System.out.println("\n=== Productos incluidos ===");
        if (productos.length == 0) {
            System.out.println("No hay productos registrados en esta suscripcion.");
        } else {
            for (ProductoCapilar producto : productos) {
                producto.mostrarInformacionProducto();
                System.out.println("---");
            }
        }

        System.out.println("Frecuencia: " + frecuencia);
        System.out.println("Precio mensual: $" + precioMensual);
        System.out.println("Estado de la suscripcion: " + (activo ? "Activa" : "Inactiva"));
    }

    // (Opcional) Método para cancelar la suscripción
    public void cancelarSuscripcion() {
        this.activo = false;
    }

    // Getters 
    public Cliente getCliente() {
        return cliente;
    }

    public ProductoCapilar[] getProductos() {
        return productos;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }

    public boolean isActivo() {
        return activo;
    }
}

