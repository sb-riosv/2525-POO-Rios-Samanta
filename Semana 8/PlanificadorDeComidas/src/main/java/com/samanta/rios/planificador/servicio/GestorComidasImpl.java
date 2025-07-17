package com.samanta.rios.planificador.servicio;

import com.samanta.rios.planificador.modelo.Comida;
import java.util.ArrayList;
import java.util.List;

public class GestorComidasImpl implements GestorComidas {

    private List<Comida> listaComidas;

    public GestorComidasImpl() {
        listaComidas = new ArrayList<>();
    }

    @Override
    public void agregarComida(Comida comida) {
        listaComidas.add(comida);
    }

    @Override
    public List<Comida> obtenerComidas() {
        return listaComidas;
    }

    @Override
    public List<Comida> obtenerComidasPorDia(String dia) {
        List<Comida> resultado = new ArrayList<>();
        for (Comida c : listaComidas) {
            if (c.getDia().equalsIgnoreCase(dia)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    @Override
    public boolean eliminarComida(String nombre, String dia, String tipo) {
        return listaComidas.removeIf(c ->
            c.getNombre().equalsIgnoreCase(nombre) &&
            c.getDia().equalsIgnoreCase(dia) &&
            c.getTipo().equalsIgnoreCase(tipo)
        );
    }
}
