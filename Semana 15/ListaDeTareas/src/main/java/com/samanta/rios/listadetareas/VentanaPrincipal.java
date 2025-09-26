package com.samanta.rios.listadetareas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Ventana principal de la aplicación
public class VentanaPrincipal extends JFrame {
    private DefaultListModel<Tarea> modeloLista;
    private JList<Tarea> listaTareas;
    private JTextField campoTexto;
    private JComboBox<String> comboPrioridad;
    private int contadorId = 1; // id autoincremental

    public VentanaPrincipal() {
        setTitle("Lista de Tareas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Modelo y lista
        modeloLista = new DefaultListModel<>();
        listaTareas = new JList<>(modeloLista);
        listaTareas.setCellRenderer(new RenderizadorTarea());

        JScrollPane scroll = new JScrollPane(listaTareas);

        // Campo de texto y combo
        campoTexto = new JTextField(15);
        comboPrioridad = new JComboBox<>(new String[]{"Alta", "Media", "Baja"});

        JButton btnAgregar = new JButton("Agregar");
        JButton btnCompletar = new JButton("Completar");
        JButton btnEliminar = new JButton("Eliminar");

        // Panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(campoTexto);
        panelSuperior.add(comboPrioridad);
        panelSuperior.add(btnAgregar);

        // Panel inferior
        JPanel panelInferior = new JPanel();
        panelInferior.add(btnCompletar);
        panelInferior.add(btnEliminar);

        add(panelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Eventos
        btnAgregar.addActionListener(e -> agregarTarea());
        btnCompletar.addActionListener(e -> completarTarea());
        btnEliminar.addActionListener(e -> eliminarTarea());

        // Enter agrega tarea
        campoTexto.addActionListener(e -> agregarTarea());

        // Doble clic completa tarea
        listaTareas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    completarTarea();
                }
            }
        });
    }

    // Método para agregar tarea
    private void agregarTarea() {
        String texto = campoTexto.getText().trim();
        if (!texto.isEmpty()) {
            String prioridad = comboPrioridad.getSelectedItem().toString();
            Tarea nueva = new Tarea(contadorId++, texto, prioridad);
            modeloLista.addElement(nueva);
            campoTexto.setText("");
        }
    }

    // Método para marcar como completada
    private void completarTarea() {
        Tarea seleccionada = listaTareas.getSelectedValue();
        if (seleccionada != null) {
            seleccionada.setCompletada(true);
            listaTareas.repaint();
        }
    }

    // Método para eliminar tarea
    private void eliminarTarea() {
        Tarea seleccionada = listaTareas.getSelectedValue();
        if (seleccionada != null) {
            modeloLista.removeElement(seleccionada);
        }
    }
}