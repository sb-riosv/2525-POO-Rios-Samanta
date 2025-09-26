package com.samanta.rios.listadetareas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

// Clase para personalizar cómo se muestran las tareas en la lista
public class RenderizadorTarea extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {

        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Tarea) {
            Tarea tarea = (Tarea) value;
            setText(tarea.getDescripcion() + " [" + tarea.getPrioridad() + "]");

            // Tachado si está completada
            if (tarea.isCompletada()) {
                setFont(getFont().deriveFont(Font.ITALIC));
                setForeground(Color.GRAY);
            } else {
                setFont(getFont().deriveFont(Font.PLAIN));
                setForeground(Color.BLACK);
            }

            // Colores por prioridad
            if (tarea.getPrioridad().equalsIgnoreCase("Alta")) {
                setForeground(Color.RED);
            } else if (tarea.getPrioridad().equalsIgnoreCase("Media")) {
                setForeground(Color.ORANGE);
            } else if (tarea.getPrioridad().equalsIgnoreCase("Baja")) {
                setForeground(Color.GREEN.darker());
            }
        }
        return c;
    }
}