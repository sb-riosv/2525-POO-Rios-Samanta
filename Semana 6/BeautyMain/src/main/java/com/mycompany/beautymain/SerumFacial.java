package com.mycompany.beautymain;

// Clase derivada que representa un serum facial, extiende ProductoCosmetico → HERENCIA y POLIMORFISMO
public class SerumFacial extends ProductoCosmetico {
    private String ingredienteActivo;  // Atributo específico del serum

    // Constructor para inicializar los atributos de la clase base y el específico
    public SerumFacial(String nombre, double precio, String ingredienteActivo) {
        super(nombre, precio);  // Llama al constructor de ProductoCosmetico
        this.ingredienteActivo = ingredienteActivo;
    }

    // Sobrescribimos el método usar() → POLIMORFISMO
    @Override
    public void usar() {
        System.out.println("Aplicando el serum '" + nombre + "' con ingrediente activo: " + ingredienteActivo);
    }

    // Método específico para este tipo de producto
    public void mostrarBeneficios() {
        System.out.println("El serum ayuda a iluminar, hidratar mejorando las manchas y la textura de la piel.");
    }
}
