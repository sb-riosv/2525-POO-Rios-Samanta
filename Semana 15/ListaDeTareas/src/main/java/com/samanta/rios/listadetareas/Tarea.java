package com.samanta.rios.listadetareas;

// Clase que representa una tarea en la lista
public class Tarea {
    private int id; // identificador único
    private String descripcion; // texto de la tarea
    private boolean completada; // indica si está hecha
    private String prioridad; // nivel de prioridad (Alta, Media, Baja)

    // Constructor
    public Tarea(int id, String descripcion, String prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false;
    }

    // Getters y setters
    public int getId() { return id; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public boolean isCompletada() { return completada; }

    public void setCompletada(boolean completada) { this.completada = completada; }

    public String getPrioridad() { return prioridad; }

    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }
}