package com.mycompany.poo_semana3_poo_samantarios;

public class RegistroClima {
    private int dia;
    private double temperatura;

    public RegistroClima(int dia) {
        this.dia = dia;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getDia() {
        return dia;
    }
}
