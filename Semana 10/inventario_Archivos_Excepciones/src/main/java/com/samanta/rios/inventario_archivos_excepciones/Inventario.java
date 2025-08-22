/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samanta.rios.inventario_archivos_excepciones;

import java.util.*;

/**
 * Maneja productos en memoria (alta, baja, modificación).
 * No hace I/O directamente.
 */
public class Inventario {
    private final Map<String, Producto> productos = new LinkedHashMap<>();

    public void agregar(Producto p) {
        if (productos.containsKey(p.getId())) {
            throw new IllegalArgumentException("Ya existe un producto con id " + p.getId());
        }
        productos.put(p.getId(), p);
    }

    public void actualizar(Producto p) {
        if (!productos.containsKey(p.getId())) {
            throw new IllegalArgumentException("No existe un producto con id " + p.getId());
        }
        productos.put(p.getId(), p);
    }

    public void eliminar(String id) {
        if (productos.remove(id) == null) {
            throw new IllegalArgumentException("No existe un producto con id " + id);
        }
    }

    public Producto obtener(String id) {
        return productos.get(id);
    }

    public Collection<Producto> listar() {
        return Collections.unmodifiableCollection(productos.values());
    }

    public boolean estaVacio() {
        return productos.isEmpty();
    }
}
