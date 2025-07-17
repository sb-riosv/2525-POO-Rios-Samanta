package com.samanta.rios.planificador.modelo;

public class Comida {
    private String nombre;
    private String tipo; // desayuno, almuerzo, cena
    private String dia;

    public Comida(String nombre, String tipo, String dia) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dia = dia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDia() {
        return dia;
    }

    @Override
    public String toString() {
        return tipo + " del " + dia + ": " + nombre;
    }
}
