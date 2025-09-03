/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Objects;

public class BuggyActividad {

    public static void main(String[] args) {

        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");

        // [Fix #1] Acceso seguro (validación de índice)
        int i = 2; // índice válido para esta lista (0..2)
        if (i >= 0 && i < nombres.size()) {
            System.out.println("Elemento en posicion " + i + ": " + nombres.get(i));
        } else {
            System.out.println("Indice fuera de rango: " + i);
        }

        // [Fix #2] Comparación correcta de String por contenido
        String buscado = "Ana";
        if ("Ana".equals(buscado)) {
            System.out.println("Encontrado");
        }

        // MAPA de teléfonos
        Map<String, String> telefonos = new HashMap<>();
        telefonos.putIfAbsent("Ana", "0991111111");
        telefonos.putIfAbsent("Luis", "0992222222");

        // [Fix #5] Evitar sobrescritura e informar si ya existe
        String previo = telefonos.putIfAbsent("Ana", "0993333333");
        if (previo != null) {
            System.out.println("Ana ya existe con " + previo + ". No se sobrescribe.");
        }

        // [Fix #3] Consulta segura: no invocar métodos sobre posible null
        String nombreConsulta = "Bea";
        if (telefonos.containsKey(nombreConsulta)) {
            System.out.println(nombreConsulta + ": " + telefonos.get(nombreConsulta));
        } else {
            System.out.println(nombreConsulta + " no esta registrada.");
        }

        // SET de inscritos
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));

        // [Fix #4] Con equals/hashCode en Alumno, este add devuelve false (duplicado lógico)
        boolean agregado = inscritos.add(new Alumno(1, "Ana"));
        if (!agregado) {
            System.out.println("Alumno con id=1 ya estaba inscrito (duplicado logico evitado).");
        }

        System.out.println("Tamano del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}

class Alumno {
    private final int id;
    private final String nombre;

    Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Igualdad lógica por id (puedes cambiar el criterio si tu profe lo pide)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno that = (Alumno) o;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "'}";
    }
}
