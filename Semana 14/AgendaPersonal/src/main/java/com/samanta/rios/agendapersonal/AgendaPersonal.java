/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.samanta.rios.agendapersonal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Clase principal de la aplicación Agenda Personal
 * Permite agregar, ver y eliminar eventos con fecha, hora y descripción.
 */
public class AgendaPersonal extends JFrame {
    // Modelo de datos de la tabla
    private DefaultTableModel modeloTabla;
    // Tabla para mostrar los eventos
    private JTable tabla;
    // Campo para la descripción del evento
    private JTextField txtDescripcion;
    // Spinners para seleccionar fecha y hora
    private JSpinner spinnerFecha;
    private JSpinner spinnerHora;

    // Constructor principal donde se arma la interfaz
    public AgendaPersonal() {
        setTitle("Agenda Personal"); // Título de la ventana
        setSize(600, 400); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra al salir
        setLocationRelativeTo(null); // Centra en la pantalla

        // ---------- PANEL DE ENTRADA ----------
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));

        // Fecha
        panelEntrada.add(new JLabel("Fecha:"));
        spinnerFecha = new JSpinner(new SpinnerDateModel());
        panelEntrada.add(spinnerFecha);

        // Hora
        panelEntrada.add(new JLabel("Hora:"));
        spinnerHora = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editorHora = new JSpinner.DateEditor(spinnerHora, "HH:mm"); // Formato de hora
        spinnerHora.setEditor(editorHora);
        panelEntrada.add(spinnerHora);

        // Descripción
        panelEntrada.add(new JLabel("Descripcion:"));
        txtDescripcion = new JTextField();
        panelEntrada.add(txtDescripcion);

        // ---------- TABLA ----------
        String[] columnas = {"Fecha", "Hora", "Descripcion"};
        modeloTabla = new DefaultTableModel(columnas, 0); // Modelo con columnas vacías
        tabla = new JTable(modeloTabla); // Crea tabla con el modelo
        JScrollPane scroll = new JScrollPane(tabla); // Scroll para la tabla

        // ---------- BOTONES ----------
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnSalir = new JButton("Salir");

        // Agregar botones al panel
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnSalir);

        // ---------- EVENTOS DE BOTONES ----------
        btnAgregar.addActionListener(e -> agregarEvento()); // Acción para agregar
        btnEliminar.addActionListener(e -> eliminarEvento()); // Acción para eliminar
        btnSalir.addActionListener(e -> System.exit(0)); // Cierra el programa

        // ---------- ORGANIZAR TODO EN EL FRAME ----------
        setLayout(new BorderLayout(10, 10));
        add(panelEntrada, BorderLayout.NORTH); // Arriba los campos de entrada
        add(scroll, BorderLayout.CENTER); // Centro la tabla
        add(panelBotones, BorderLayout.SOUTH); // Abajo los botones
    }

    // Método para agregar un evento a la tabla
    private void agregarEvento() {
        String descripcion = txtDescripcion.getText().trim();
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La descripcion no puede estar vacia",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Se agrega una nueva fila con los datos
        modeloTabla.addRow(new Object[]{
                spinnerFecha.getValue(),
                spinnerHora.getValue(),
                descripcion
        });
        txtDescripcion.setText(""); // Limpia el campo después de agregar
    }

    // Método para eliminar un evento seleccionado
    private void eliminarEvento() {
        int fila = tabla.getSelectedRow(); // Obtiene la fila seleccionada
        if (fila == -1) { // Si no hay fila seleccionada
            JOptionPane.showMessageDialog(this, "Seleccione un evento para eliminar",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Mensaje de confirmación antes de eliminar
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el evento?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            modeloTabla.removeRow(fila); // Elimina la fila del modelo
        }
    }

    // Método main: inicia la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgendaPersonal().setVisible(true));
    }
}
