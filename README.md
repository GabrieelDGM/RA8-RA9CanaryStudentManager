# DOCUMENTACIÓN DEL PROYECTO
# Canary Student Manager – Práctica RA8 y RA9

# VER EJEMPLOS
[Ejemplos](/src/net/com/salesianos/docs/ejemplo.md)

1. Introducción

## Instrucciones para compilar y ejecutar con db4o

1. Asegúrate de que el archivo `db4o.jar` esté en la carpeta `lib/`.
2. Para compilar desde la terminal (cmd), usa:
	```cmd
	javac -cp lib/db4o.jar -d bin src/net/com/salesianos/model/Student.java src/net/com/salesianos/persistence/DBManager.java src/net/com/salesianos/persistence/StudentDAO.java src/App.java
	```
3. Para ejecutar:
	```cmd
	java -cp bin;lib/db4o.jar App
	```
	(En Linux/Mac usa `:` en vez de `;`)
La aplicación Canary Student Manager ha sido desarrollada en Java con el objetivo de gestionar un conjunto de estudiantes mediante una base de datos orientada a objetos usando db4o.
El proyecto permite realizar operaciones básicas CRUD y está estructurado de forma modular siguiendo las indicaciones de la práctica.

2. Objetivos

Implementar una aplicación Java con persistencia orientada a objetos.

Utilizar la librería db4o para almacenar objetos Student.

Asegurar la integridad de los datos (ID único y validaciones).

Diseñar operaciones CRUD mediante un DAO.

Aplicar buenas prácticas de uso de Git mediante un sistema de ramas funcionales.

3. Tecnologías Utilizadas

-- Java

-- db4o (Database for Objects)

-- Git y GitHub
4. Descripción de las Clases
Student

Representa la entidad del sistema. Contiene datos básicos (id, nombre, apellidos, año y centro) y métodos de acceso.

DBManager

Gestiona la apertura y cierre del archivo students.db4o. Centraliza la conexión para mantener la integridad.

StudentDAO

Implementa las operaciones CRUD: guardar, buscar todos, buscar por ID, eliminar y modificar estudiantes.

App

Contiene el menú principal por consola e interactúa con el DAO para realizar las acciones del usuario.

5. Flujo de Trabajo con Git

Se utilizó un modelo basado en ramas:

feature/student

feature/dao

feature/manager

feature/main

main

Cada rama incorporó una parte del proyecto y posteriormente se integró mediante Pull Requests.

9. Conclusión

El proyecto cumple con los requisitos de los RA8 y RA9, demostrando el uso de persistencia orientada a objetos, diseño modular, control de integridad y un flujo de trabajo correcto con Git.
La aplicación es funcional, mantiene la integridad de los datos y utiliza db4o de forma adecuada.

