# Manipulación de Archivos y Manejo de Excepciones en Java
Este proyecto es una demostración práctica de **lectura y escritura de archivos** en Java, aplicando **Programación Orientada a Objetos** y manejo de **excepciones personalizadas**.

## Objetivo
Implementar una solución que:
- Escriba contenido en un archivo de texto.
- Lea el contenido línea por línea.
- Valide que el archivo no esté vacío.
- Maneje errores de forma controlada, incluyendo una excepción personalizada.

## Estructura del proyecto
- **`Main`**: Clase principal que coordina las operaciones.
- **`GestorDeArchivo`**: Encapsula métodos para guardar y leer archivos (`guardar()`, `leer()`).
- **`ValidadorArchivo`**: Contiene el método `verificarNoVacio()` para validar que un archivo no esté vacío.
- **`ArchivoVacioException`**: Excepción personalizada que se lanza cuando un archivo no contiene datos.

## Ejemplo de uso
Al ejecutar el programa:
1. Se guarda un archivo llamado `frasesMotivacionales.txt` con frases motivadoras.
2. Se valida que el archivo tenga contenido.
3. Se lee línea por línea y se muestra numerado en consola.
4. Se realiza un segundo test creando un archivo vacío para disparar la excepción personalizada.

## Características de los códigos
- Uso de **try-with-resources** para cerrar recursos automáticamente.
- Separación de responsabilidades en clases independientes.
- Manejo de errores robusto con **try-catch-finally**.
- Ejemplo claro de **excepción personalizada**.
