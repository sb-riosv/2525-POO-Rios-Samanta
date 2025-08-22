/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.samanta.rios.inventario_archivos_excepciones;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Menú por consola para gestionar el inventario con persistencia en archivo.
 */
public class Main {

    private static final Path RUTA = Path.of("inventario.txt");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorDeArchivo gestor = new GestorDeArchivo();
        InventarioFileRepository repo = new InventarioFileRepository(RUTA, gestor);
        Inventario inventario;

        try {
            inventario = repo.cargar();
            System.out.println("Inventario cargado. Productos: " + inventario.listar().size());
        } catch (IOException e) {
            System.err.println("Error al cargar inventario: " + e.getMessage());
            return;
        }

        int opcion;
        do {
            System.out.println("\n=== MENU INVENTARIO ===");
            System.out.println("1) Listar productos");
            System.out.println("2) Agregar producto");
            System.out.println("3) Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("0) Salir");
            System.out.print("Elige una opcion: ");
            String entrada = sc.nextLine().trim();
            opcion = entrada.isEmpty() ? -1 : Integer.parseInt(entrada);

            try {
                switch (opcion) {
                    case 1 -> listar(inventario);
                    case 2 -> { agregar(sc, inventario); repo.guardarTodo(inventario); }
                    case 3 -> { actualizar(sc, inventario); repo.guardarTodo(inventario); }
                    case 4 -> { eliminar(sc, inventario); repo.guardarTodo(inventario); }
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción invalida.");
                }
            } catch (Exception e) {
                System.err.println("❌ " + e.getMessage());
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void listar(Inventario inv) {
        if (inv.estaVacio()) {
            System.out.println("Inventario vacio.");
            return;
        }
        inv.listar().forEach(System.out::println);
    }

    private static void agregar(Scanner sc, Inventario inv) {
        System.out.print("ID: "); String id = sc.nextLine().trim();
        System.out.print("Nombre: "); String nombre = sc.nextLine().trim();
        System.out.print("Cantidad: "); int cantidad = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Precio: "); double precio = Double.parseDouble(sc.nextLine().trim());
        inv.agregar(new Producto(id, nombre, cantidad, precio));
    }

    private static void actualizar(Scanner sc, Inventario inv) {
        System.out.print("ID a actualizar: "); String id = sc.nextLine().trim();
        Producto p = inv.obtener(id);
        if (p == null) throw new IllegalArgumentException("No existe el producto con id " + id);

        System.out.print("Nuevo nombre (" + p.getNombre() + "): ");
        String nombre = sc.nextLine().trim();
        if (!nombre.isBlank()) p.setNombre(nombre);

        System.out.print("Nueva cantidad (" + p.getCantidad() + "): ");
        String scantidad = sc.nextLine().trim();
        if (!scantidad.isBlank()) p.setCantidad(Integer.parseInt(scantidad));

        System.out.print("Nuevo precio (" + p.getPrecio() + "): ");
        String sprecio = sc.nextLine().trim();
        if (!sprecio.isBlank()) p.setPrecio(Double.parseDouble(sprecio));

        inv.actualizar(p);
    }

    private static void eliminar(Scanner sc, Inventario inv) {
        System.out.print("ID a eliminar: ");
        String id = sc.nextLine().trim();
        inv.eliminar(id);
    }
}
