/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programasuscripcionmensual;

/**
 *
 * @author Usuario
 */
public class ProductoCapilar {
    private String nombreProducto;
    private String tipo; // Ej: Shampoo, Mascarilla, Sérum, etc.
    private String usoRecomendado; // Ej: cabello seco, graso, etc.
    private double precio;

    // Constructor por defecto
    public ProductoCapilar() {
        this.nombreProducto = "Producto Generico";
        this.tipo = "Tratamiento";
        this.usoRecomendado = "todo tipo de cabello";
        this.precio = 9.99;
    }

    // Constructor parametrizado completo
    public ProductoCapilar(String nombreProducto, String tipo, String usoRecomendado, double precio) {
        this.nombreProducto = nombreProducto;
        this.tipo = tipo;
        this.usoRecomendado = usoRecomendado;
        this.precio = precio;
    }

    // Sobrecarga: solo nombre y tipo (precio y uso por defecto)
    public ProductoCapilar(String nombreProducto, String tipo) {
        this.nombreProducto = nombreProducto;
        this.tipo = tipo;
        this.usoRecomendado = "cabello normal";
        this.precio = 8.50;
    }

    // Método para mostrar los datos del producto
    public void mostrarInformacionProducto() {
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Tipo: " + tipo);
        System.out.println("Uso recomendado: " + usoRecomendado);
        System.out.println("Precio: $" + precio);
    }

    // Getters 
    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUsoRecomendado() {
        return usoRecomendado;
    }

    public double getPrecio() {
        return precio;
    }
}
