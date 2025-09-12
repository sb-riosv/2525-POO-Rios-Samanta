/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samanta.rios.appguibasica;

import javax.swing.SwingUtilities;

/**
 * Punto de entrada de la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        // Ejecutar la UI en el Event Dispatch Thread (buenas prácticas Swing)
        SwingUtilities.invokeLater(() -> new AppGUIBasica().setVisible(true));
    }
}
