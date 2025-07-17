package com.samanta.rios.planificador.dashboard;

import com.samanta.rios.planificador.modelo.Comida;
import com.samanta.rios.planificador.servicio.GestorComidas;
import com.samanta.rios.planificador.servicio.GestorComidasImpl;
import com.samanta.rios.planificador.vista.ConsolaVista;

import java.util.List;
import java.util.Scanner;
/**
 * Clase principal del sistema Planificador de Comidas.
 * Muestra un menú en consola para gestionar el registro, visualización y eliminación de comidas
 * asignadas a días de la semana.
 * 
 * Este sistema aplica principios de Programación Orientada a Objetos y estructura modular por paquetes.
 * 
 * Autora: Samanta Ríos
 */

public class Dashboard {

    /**
 * Método principal que ejecuta la aplicación.
 * Muestra el menú y permite gestionar comidas desde consola.
 * 
 * @param args argumentos de línea de comandos (no se utilizan)
 */
    public static void main(String[] args) {
        ConsolaVista vista = new ConsolaVista();
        GestorComidas gestor = new GestorComidasImpl();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        vista.mostrarMensaje("Bienvenida, Samanta  Planifica tus comidas semanales.\n");

        while (!salir) {
            vista.mostrarMenu();
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    Comida nueva = vista.leerComida();
                    gestor.agregarComida(nueva);
                    vista.mostrarMensaje(" Comida registrada con exito.");
                    break;
                case "2":
                    List<Comida> todas = gestor.obtenerComidas();
                    vista.mostrarComidas(todas);
                    break;
                case "3":
                    String dia = vista.leerDia();
                    List<Comida> porDia = gestor.obtenerComidasPorDia(dia);
                    vista.mostrarComidas(porDia);
                    break;
                case "4":
                    String[] datos = vista.leerDatosParaEliminar();
                    boolean eliminada = gestor.eliminarComida(datos[0], datos[2], datos[1]);
                    if (eliminada) {
                        vista.mostrarMensaje("️ Comida eliminada con exito.");
                    } else {
                        vista.mostrarMensaje(" No se encontro la comida para eliminar.");
                    }
                    break;
                case "5":
                    salir = true;
                    vista.mostrarMensaje("Hasta pronto, Samanta");
                    break;
                default:
                    vista.mostrarMensaje(" Opcion invalida. Intente nuevamente.");
            }
        }
    }
}
