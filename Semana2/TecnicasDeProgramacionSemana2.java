public class TecnicasDeProgramacionSemana2 {

    // ==========================
    // 1. Ejemplo de Abstracción
    // ==========================
    abstract static class Dispositivo {
        private String modelo;

        public Dispositivo(String modelo) {
            this.modelo = modelo;
        }

        public String getModelo() {
            return modelo;
        }

        public abstract void encender();
    }

    static class Laptop extends Dispositivo {
        public Laptop(String modelo) {
            super(modelo);
        }

        @Override
        public void encender() {
            System.out.println("Encendiendo la laptop: " + getModelo());
        }
    }

    // ============================
    // 2. Ejemplo de Encapsulación
    // ============================
    static class Producto {
        private String nombre;
        private double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public void setPrecio(double nuevoPrecio) {
            if (nuevoPrecio > 0) {
                precio = nuevoPrecio;
            }
        }

        public double getPrecio() {
            return precio;
        }

        public String getNombre() {
            return nombre;
        }
    }

    // ========================
    // 3. Ejemplo de Herencia
    // ========================
    static class Persona {
        String nombre;

        public Persona(String nombre) {
            this.nombre = nombre;
        }

        public void saludar() {
            System.out.println("Hola, soy " + nombre);
        }
    }

    static class Estudiante extends Persona {
        String carrera;

        public Estudiante(String nombre, String carrera) {
            super(nombre);
            this.carrera = carrera;
        }

        public void mostrarCarrera() {
            System.out.println("Estudio la carrera de: " + carrera);
        }
    }

    // ==========================
    // 4. Ejemplo de Polimorfismo
    // ==========================
    static class Bot {
        public void responder() {
            System.out.println("Bot genérico respondiendo...");
        }
    }

    static class BotSaludo extends Bot {
        @Override
        public void responder() {
            System.out.println("¡Hola! ¿Cómo estás?");
        }
    }

    static class BotDespedida extends Bot {
        @Override
        public void responder() {
            System.out.println("¡Hasta luego!");
        }
    }

    // ==================
    // Método Principal
    // ==================
    public static void main(String[] args) {

        // Abstracción
        Dispositivo miLaptop = new Laptop("Lenovo ThinkPad");
        miLaptop.encender();

        // Encapsulación
        Producto producto = new Producto("Audífonos", 29.99);
        producto.setPrecio(35.50);
        System.out.println("Producto: " + producto.getNombre() + " - Precio: $" + producto.getPrecio());

        // Herencia
        Estudiante est = new Estudiante("Samanta", "Tecnologías de la Información");
        est.saludar();
        est.mostrarCarrera();

        // Polimorfismo
        Bot bot1 = new BotSaludo();
        Bot bot2 = new BotDespedida();
        bot1.responder();  // Respuesta personalizada
        bot2.responder();  // Otra respuesta
    }
}
