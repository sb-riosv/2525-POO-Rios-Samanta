# Planificador de Comidas

Este programa permite al usuario planificar sus comidas semanales desde consola.  
Se pueden registrar comidas indicando el día y el tipo (desayuno, almuerzo o cena), consultar el listado completo, filtrar por día específico y eliminar comidas registradas.

La aplicación está desarrollada en Java y organizada mediante paquetes (`modelo`, `vista`, `servicio` y `dashboard`), aplicando principios básicos de la Programación Orientada a Objetos (POO) para facilitar el mantenimiento y la escalabilidad del código.

Para ejecutar el sistema, basta con iniciar la clase `Dashboard`, que contiene el menú principal y permite interactuar con todas las funcionalidades desde la consola.

## Estructura del proyecto

- `modelo`: contiene la clase `Comida`, que representa los datos de una comida (nombre, tipo, día).
- `vista`: incluye la clase `ConsolaVista`, encargada de mostrar el menú y gestionar la entrada del usuario.
- `servicio`: alberga la lógica de negocio, con la interfaz `GestorComidas` y su implementación `GestorComidasImpl`.
- `dashboard`: contiene la clase `Dashboard`, punto de entrada del sistema que coordina el funcionamiento general.

## Principios SOLID aplicados

Este proyecto aplica algunos principios del enfoque SOLID para mantener un diseño limpio y estructurado:

- **Responsabilidad Única (SRP):** cada clase cumple una función específica y bien definida.
- **Abierto/Cerrado (OCP):** el sistema puede extenderse sin necesidad de modificar las clases existentes.
- **Sustitución de Liskov (LSP):** la implementación del gestor de comidas respeta el contrato definido por su interfaz, permitiendo sustituirla sin afectar otras partes del sistema.
