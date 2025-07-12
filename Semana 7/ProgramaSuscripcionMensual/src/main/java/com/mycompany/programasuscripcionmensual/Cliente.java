/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programasuscripcionmensual;

/**
 *
 * @author Usuario
 */
public class Cliente {
    private String nombre;
    private String email;
    private String telefono;
    private String tipoCabello;

    // Constructor por defecto con tus datos
    public Cliente() {
        this.nombre = "Samantha Rios Vivanco";
        this.email = "sriosvivanco@gmail.com";
        this.telefono = "0987130124";
        this.tipoCabello = "normal";
    }

    // Constructor parametrizado completo
    public Cliente(String nombre, String email, String telefono, String tipoCabello) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.tipoCabello = tipoCabello;
    }

    // Sobrecarga: solo con nombre y tipo de cabello
    public Cliente(String nombre, String tipoCabello) {
        this.nombre = nombre;
        this.email = "ldrs1993@gmail.com";
        this.telefono = "0987654536";
        this.tipoCabello = tipoCabello;
    }

    // Método para mostrar los datos del cliente
    public void mostrarDatosCliente() {
        System.out.println("Cliente: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Telefono: " + telefono);
        System.out.println("Tipo de Cabello: " + tipoCabello);
    }

    // Getters 
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipoCabello() {
        return tipoCabello;
    }
}
