package com.samanta.rios.planificador.servicio;

import com.samanta.rios.planificador.modelo.Comida;
import java.util.List;

public interface GestorComidas {
    void agregarComida(Comida comida);
    List<Comida> obtenerComidas();
    List<Comida> obtenerComidasPorDia(String dia);
    boolean eliminarComida(String nombre, String dia, String tipo);
}
