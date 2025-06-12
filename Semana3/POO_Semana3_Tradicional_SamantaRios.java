package com.mycompany.poo_semana3_tradicional_samantarios;

import java.util.Scanner;

public class POO_Semana3_Tradicional_SamantaRios {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] temperaturas = new double[7];
        double suma = 0;

        System.out.println("Temperaturas registradas durante la semana en Machala:");

        for (int i = 0; i < 7; i++) {
            System.out.print("Temperatura del dia " + (i + 1) + ": ");
            temperaturas[i] = sc.nextDouble();
            suma += temperaturas[i];
        }

        double promedio = suma / 7;
        System.out.println("\nPromedio de temperatura semanal en Machala: " + promedio + " °C");
    }
}
