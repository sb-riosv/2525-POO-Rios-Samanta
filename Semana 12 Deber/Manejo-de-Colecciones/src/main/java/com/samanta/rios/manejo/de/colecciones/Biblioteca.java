/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samanta.rios.manejo.de.colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Biblioteca {
    private final Map<String, Libro> catalogoPorIsbn = new HashMap<>();
    private final Map<String, Usuario> usuariosPorId = new HashMap<>();
    private final Set<String> isbnsPrestados = new HashSet<>();

    // Libros
    public void añadirLibro(Libro libro) {
        if (libro == null) throw new IllegalArgumentException("Libro nulo");
        if (catalogoPorIsbn.containsKey(libro.getIsbn()))
            throw new IllegalArgumentException("El ISBN ya existe en el catalogo");
        catalogoPorIsbn.put(libro.getIsbn(), libro);
    }

    public boolean quitarLibro(String isbn) {
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException("ISBN invalido");
        if (!catalogoPorIsbn.containsKey(isbn)) return false;
        if (isbnsPrestados.contains(isbn))
            throw new IllegalStateException("No se puede quitar: el libro esta prestado");
        catalogoPorIsbn.remove(isbn);
        return true;
    }

    // Usuarios
    public void registrarUsuario(Usuario u) {
        if (u == null) throw new IllegalArgumentException("Usuario nulo");
        if (usuariosPorId.containsKey(u.getId()))
            throw new IllegalArgumentException("El usuario ya está registrado");
        usuariosPorId.put(u.getId(), u);
    }

    public boolean darBajaUsuario(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID invalido");
        Usuario u = usuariosPorId.get(id);
        if (u == null) return false;
        if (!u.getIsbnsPrestados().isEmpty())
            throw new IllegalStateException("No se puede dar de baja: tiene libros prestados");
        usuariosPorId.remove(id);
        return true;
    }

    // Préstamos
    public void prestarLibro(String idUsuario, String isbn) {
        Usuario u = usuariosPorId.get(idUsuario);
        if (u == null) throw new IllegalArgumentException("Usuario no encontrado");
        Libro l = catalogoPorIsbn.get(isbn);
        if (l == null) throw new IllegalArgumentException("Libro no encontrado");
        if (isbnsPrestados.contains(isbn)) throw new IllegalStateException("El libro ya esta prestado");
        if (u.getIsbnsPrestados().contains(isbn)) throw new IllegalStateException("El usuario ya tiene este ISBN");

        u.prestar(isbn);
        isbnsPrestados.add(isbn);
    }

    public void devolverLibro(String idUsuario, String isbn) {
        Usuario u = usuariosPorId.get(idUsuario);
        if (u == null) throw new IllegalArgumentException("Usuario no encontrado");
        if (!u.getIsbnsPrestados().contains(isbn))
            throw new IllegalStateException("Ese usuario no tiene prestado ese ISBN");

        u.devolver(isbn);
        isbnsPrestados.remove(isbn);
    }

    // Búsquedas
    public List<Libro> buscarPorTitulo(String texto) {
        String q = texto == null ? "" : texto.toLowerCase();
        List<Libro> r = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getTitulo().toLowerCase().contains(q)) r.add(l);
        }
        return r;
    }

    public List<Libro> buscarPorAutor(String texto) {
        String q = texto == null ? "" : texto.toLowerCase();
        List<Libro> r = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getAutor().toLowerCase().contains(q)) r.add(l);
        }
        return r;
    }

    public List<Libro> buscarPorCategoria(String texto) {
        String q = texto == null ? "" : texto.toLowerCase();
        List<Libro> r = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getCategoria().toLowerCase().contains(q)) r.add(l);
        }
        return r;
    }

    // Listado
    public List<Libro> listarPrestados(String idUsuario) {
        Usuario u = usuariosPorId.get(idUsuario);
        if (u == null) throw new IllegalArgumentException("Usuario no encontrado");
        List<Libro> r = new ArrayList<>();
        for (String isbn : u.getIsbnsPrestados()) {
            Libro l = catalogoPorIsbn.get(isbn);
            if (l != null) r.add(l);
        }
        return r;
    }
}
