package com.mycompany.poo_semana3_poo_samantarios;

import java.util.Scanner;

public class PromedioClimaMachala {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistroClima[] semana = new RegistroClima[7];

        System.out.println("Temperaturas de la semana en Machala:");

        for (int i = 0; i < semana.length; i++) {
            semana[i] = new RegistroClima(i + 1);
            System.out.print("Temperatura del dia " + (i + 1) + ": ");
            double temp = sc.nextDouble();
            semana[i].setTemperatura(temp);
        }

        double suma = 0;
        for (RegistroClima dia : semana) {
            suma += dia.getTemperatura();
        }

        double promedio = suma / semana.length;
        System.out.printf("\nPromedio semanal: %.2f °C\n", promedio);
    }
}
