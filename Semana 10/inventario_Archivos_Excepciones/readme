# Sistema de Gestión de Inventarios Mejorado

Este proyecto corresponde al **deber de la semana 10** de la materia *Programación Orientada a Objetos* en Java.  
Fue desarrollado tomando como **base el código de la semana 9**, donde se trabajó la **manipulación de archivos y manejo de excepciones personalizadas**.


## Objetivos del deber
- **Reutilizar y mejorar** el código de la semana 9 (clases `GestorDeArchivo`, `ValidadorArchivo` y `ArchivoVacioException`).  
- Implementar un **sistema práctico de gestión de inventario** con operaciones de agregar, listar, actualizar y eliminar productos.  
- Incorporar **persistencia en archivos de texto (inventario.txt)** para guardar y recuperar los productos.  
- Manejar las **excepciones de entrada/salida** (`IOException`, `FileNotFoundException`, `AccessDeniedException`) y la excepción personalizada `ArchivoVacioException`.  
- Diseñar un programa con **interfaz de consola** que guíe al usuario en la gestión del inventario.  


## Relación con el deber anterior (Semana 9)
En la **semana 9** se construyó un ejercicio de práctica para:
- **Guardar contenido en archivos** (`GestorDeArchivo`).  
- **Leer contenido línea por línea**.  
- **Validar si un archivo estaba vacío** con `ValidadorArchivo` y lanzar una excepción personalizada `ArchivoVacioException`.  
- **Probar el manejo de excepciones** en una clase `Main`.  

Ese código fue la **base de este proyecto**.  
En esta semana (Semana 10), esas clases se reutilizan y amplían para resolver un problema más realista: la gestión de inventarios con almacenamiento en archivos.


## Funcionalidad actual (Semana 10)
- **Agregar productos**: el usuario introduce ID, nombre, cantidad y precio.  
- **Actualizar productos**: se modifican los datos de un producto existente.  
- **Eliminar productos**: se elimina un producto a partir de su ID.  
- **Listar productos**: se muestran en consola todos los productos cargados en memoria.  
- **Persistencia**: los cambios se guardan automáticamente en el archivo `inventario.txt`.  
- **Carga inicial**: al iniciar el programa, se leen los datos existentes del archivo para reconstruir el inventario.  


##  Manejo de errores
- **Archivo inexistente** → se crea automáticamente con encabezado.  
- **Archivo vacío** → se inicializa un inventario vacío.  
- **ID duplicado** → muestra error y no permite guardar.  
- **Errores de permisos o de I/O** → se notifica claramente en consola.  
- **Líneas corruptas en el archivo** → se ignoran y se muestra advertencia al usuario.  


