/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samanta.rios.inventario_archivos_excepciones;

import java.util.Objects;

/**
 * Entidad de dominio para un producto del inventario.
 * Formato CSV: id,nombre,cantidad,precio
 */
public class Producto {
    private String id;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String id, String nombre, int cantidad, double precio) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id no puede ser vacío");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre no puede ser vacío");
        if (cantidad < 0) throw new IllegalArgumentException("cantidad no puede ser negativa");
        if (precio < 0) throw new IllegalArgumentException("precio no puede ser negativo");
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre no puede ser vacío");
        this.nombre = nombre;
    }
    public void setCantidad(int cantidad) {
        if (cantidad < 0) throw new IllegalArgumentException("cantidad no puede ser negativa");
        this.cantidad = cantidad;
    }
    public void setPrecio(double precio) {
        if (precio < 0) throw new IllegalArgumentException("precio no puede ser negativo");
        this.precio = precio;
    }

    // CSV helpers
    public String toCsv() {
        return String.format("%s,%s,%d,%.2f", id, nombre, cantidad, precio);
    }

    public static Producto fromCsv(String csvLine, int linea) {
        String[] partes = csvLine.split(",", -1);
        if (partes.length != 4) {
            throw new IllegalArgumentException("Línea " + linea + ": se esperaban 4 columnas (id,nombre,cantidad,precio)");
        }
        String id = partes[0].trim();
        String nombre = partes[1].trim();
        int cantidad = Integer.parseInt(partes[2].trim());
        double precio = Double.parseDouble(partes[3].trim());
        return new Producto(id, nombre, cantidad, precio);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto p = (Producto) o;
        return Objects.equals(id, p.id);
    }
    @Override public int hashCode() { return Objects.hash(id); }

    @Override public String toString() {
        return String.format("%s - %s | cant=%d | $%.2f", id, nombre, cantidad, precio);
    }
}
