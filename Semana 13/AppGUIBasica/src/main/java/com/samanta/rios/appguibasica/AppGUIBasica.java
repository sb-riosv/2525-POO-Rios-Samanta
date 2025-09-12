/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.samanta.rios.appguibasica;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AppGUIBasica extends JFrame {

    // Componentes principales
    private final JTextField campoTexto;
    private final JButton btnAgregar;
    private final JButton btnLimpiar;
    private final JList<String> lista;
    private final DefaultListModel<String> modeloLista;
    private final JLabel lblEstado; // muestra mensajes/selección

    public AppGUIBasica() {
        // Configuración de la ventana
        setTitle("Aplicación GUI Básica - Swing + Maven");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(520, 360);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        // ----- Panel superior (formulario) -----
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        panelSuperior.add(new JLabel("Dato:"));

        campoTexto = new JTextField(22);
        panelSuperior.add(campoTexto);

        btnAgregar = new JButton("Agregar");
        btnLimpiar = new JButton("Limpiar");
        panelSuperior.add(btnAgregar);
        panelSuperior.add(btnLimpiar);

        add(panelSuperior, BorderLayout.NORTH);

        // ----- Centro: lista con scroll -----
        modeloLista = new DefaultListModel<>();
        lista = new JList<>(modeloLista);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(lista);

        add(scroll, BorderLayout.CENTER);

        // ----- Sur: barra de estado -----
        lblEstado = new JLabel("Listo.");
        lblEstado.setBorder(BorderFactory.createEmptyBorder(4, 8, 8, 8));
        add(lblEstado, BorderLayout.SOUTH);

        // ----- Eventos -----
        btnAgregar.addActionListener(this::onAgregar);
        btnLimpiar.addActionListener(this::onLimpiar);

        // Enter en el campo de texto también agrega
        campoTexto.addActionListener(this::onAgregar);

        // Opcional: reaccionar a la selección en la lista
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String sel = lista.getSelectedValue();
                    lblEstado.setText(sel == null ? "Sin selección." : "Seleccionado: " + sel);
                }
            }
        });
    }

    // ---- LÓGICA ----
    private void onAgregar(ActionEvent e) {
        String texto = campoTexto.getText().trim();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No puedes agregar un valor vacío.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );
            campoTexto.requestFocus();
            return;
        }
        modeloLista.addElement(texto);
        campoTexto.setText("");
        campoTexto.requestFocus();
        lblEstado.setText("Agregado: " + texto + " (Total: " + modeloLista.size() + ")");
    }

    private void onLimpiar(ActionEvent e) {
        int opc = JOptionPane.showConfirmDialog(
                this,
                "¿Deseas limpiar TODO el listado?",
                "Confirmar limpieza",
                JOptionPane.YES_NO_OPTION
        );
        if (opc == JOptionPane.YES_OPTION) {
            modeloLista.clear();          // borra todo el listado
            lista.clearSelection();       // limpia selección
        }
        campoTexto.setText("");           // siempre limpia el campo
        campoTexto.requestFocus();
        lblEstado.setText("Listo.");
    }
}
