/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samanta.rios.manejo.de.colecciones;

public class Libro {
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final String categoria;

    public Libro(String isbn, String titulo, String autor, String categoria) {
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException("ISBN no puede estar vacio");
        if (titulo == null || titulo.isBlank()) throw new IllegalArgumentException("Título no puede estar vacio");
        if (autor == null) autor = "";
        if (categoria == null) categoria = "";
        this.isbn = isbn.trim();
        this.titulo = titulo.trim();
        this.autor = autor.trim();
        this.categoria = categoria.trim();
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return titulo + " (" + autor + ")";
    }
}
