package com.samanta.rios.planificador.vista;

import com.samanta.rios.planificador.modelo.Comida;
import java.util.List;
import java.util.Scanner;

public class ConsolaVista {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n--- PLANIFICADOR DE COMIDAS ---");
        System.out.println("1. Agregar comida");
        System.out.println("2. Ver todas las comidas");
        System.out.println("3. Ver comidas por dia");
        System.out.println("4. Eliminar comida");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    public Comida leerComida() {
        System.out.print("Nombre de la comida: ");
        String nombre = scanner.nextLine();

        System.out.print("Tipo (desayuno, almuerzo, cena): ");
        String tipo = scanner.nextLine();

        System.out.print("Dia de la semana: ");
        String dia = scanner.nextLine();

        return new Comida(nombre, tipo, dia);
    }

    public String leerDia() {
        System.out.print("Ingrese el dia a consultar: ");
        return scanner.nextLine();
    }

    public String[] leerDatosParaEliminar() {
        System.out.print("Nombre de la comida a eliminar: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo de comida: ");
        String tipo = scanner.nextLine();
        System.out.print("Dia de la semana: ");
        String dia = scanner.nextLine();
        return new String[]{nombre, tipo, dia};
    }

    public void mostrarComidas(List<Comida> comidas) {
        if (comidas.isEmpty()) {
            System.out.println("No hay comidas registradas.");
        } else {
            System.out.println("\nComidas registradas:");
            for (Comida c : comidas) {
                System.out.println("- " + c);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
