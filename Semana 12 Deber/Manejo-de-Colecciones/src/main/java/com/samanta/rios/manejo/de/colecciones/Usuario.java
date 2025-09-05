/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samanta.rios.manejo.de.colecciones;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private final String id;
    private final String nombre;
    private final List<String> isbnsPrestados;

    public Usuario(String id, String nombre) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID no puede estar vacio");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre no puede estar vacio");
        this.id = id.trim();
        this.nombre = nombre.trim();
        this.isbnsPrestados = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<String> getIsbnsPrestados() { return new ArrayList<>(isbnsPrestados); }

    // uso interno por Biblioteca
    void prestar(String isbn) { isbnsPrestados.add(isbn); }
    void devolver(String isbn) { isbnsPrestados.remove(isbn); }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}

