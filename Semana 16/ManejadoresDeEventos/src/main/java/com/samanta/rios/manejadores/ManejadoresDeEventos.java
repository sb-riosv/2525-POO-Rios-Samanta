
package com.samanta.rios.manejadores;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class ManejadoresDeEventos extends JFrame {

    private DefaultListModel<Item> modelo;
    private JList<Item> lista;
    private JButton boton;

    /** Modelo simple de ítem */
    private static class Item {
        String texto;
        boolean done;
        Item(String t) { this.texto = t; }
        void toggle() { done = !done; }
    }

    /** Renderer: ASCII [X]/[ ] y tachado con HTML */
    private static class ItemRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {
            JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Item it) {
                String prefix = it.done ? "[X] " : "[ ] ";
                String html = it.done
                        ? "<html>" + prefix + "<span style='text-decoration: line-through; color: gray;'>"
                          + escape(it.texto) + "</span></html>"
                        : "<html>" + prefix + escape(it.texto) + "</html>";
                lbl.setText(html);
                lbl.setFont(lbl.getFont().deriveFont(Font.PLAIN, 16f));
            }
            return lbl;
        }
        private static String escape(String s) {
            return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;");
        }
    }

    public ManejadoresDeEventos() {
        super("Manejadores de Eventos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 260);
        setLocationRelativeTo(null);

        // Modelo y lista
        modelo = new DefaultListModel<>();
        modelo.addElement(new Item("Tarea 1"));
        modelo.addElement(new Item("Tarea 2"));
        modelo.addElement(new Item("Tarea 3"));

        lista = new JList<>(modelo);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setCellRenderer(new ItemRenderer());
        lista.setSelectedIndex(0); // selección inicial

        // Acción de alternar
        Action toggleAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = lista.getSelectedIndex();
                if (i >= 0) {
                    Item it = modelo.getElementAt(i);
                    it.toggle();
                    // Notificar y repintar
                    modelo.set(i, it);
                    lista.repaint();
                    System.out.println("Estado: " + (it.done ? "COMPLETADO" : "PENDIENTE") + " -> " + it.texto);
                } else {
                    System.out.println("No hay elemento seleccionado.");
                }
            }
        };

        // Key Bindings: 'c' y 'C' cuando la LISTA tiene foco
        InputMap im = lista.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap am = lista.getActionMap();
        im.put(KeyStroke.getKeyStroke('c'), "toggleC");
        im.put(KeyStroke.getKeyStroke('C'), "toggleC");
        am.put("toggleC", toggleAction);

        // Key Binding GLOBAL: 'c' y 'C' 
        JComponent root = getRootPane();
        InputMap imRoot = root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap amRoot = root.getActionMap();
        imRoot.put(KeyStroke.getKeyStroke('c'), "toggleCGlobal");
        imRoot.put(KeyStroke.getKeyStroke('C'), "toggleCGlobal");
        amRoot.put("toggleCGlobal", toggleAction);

        // Botón 
        boton = new JButton("Acción");
        boton.addActionListener(ev -> JOptionPane.showMessageDialog(this, "¡Botón presionado!"));

        // Layout
        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);

       
        addWindowListener(new WindowAdapter() {
            @Override public void windowOpened(WindowEvent e) {
                lista.requestFocusInWindow();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManejadoresDeEventos().setVisible(true));
    }
}
