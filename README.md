# Pokemon App

Bienvenido a **Pokemon App**, una aplicación desarrollada en **Java** con el framework **Spring Boot** para gestionar información sobre entrenadores y pokémones. Esta aplicación está diseñada para ofrecer un sistema CRUD completo, pruebas con Postman, e integración con **Docker Compose** para un fácil despliegue.

## Tecnologías utilizadas

- **Lenguaje**: Java
- **Framework**: Spring Boot
- **Base de datos**: PostgreSQL
- **Pruebas**: Postman
- **Contenedores**: Docker Compose

## Requisitos previos

Antes de comenzar, asegúrate de tener instalados:

- Docker y Docker Compose
- Java 11 o superior
- Un IDE compatible con Spring Boot (opcional, pero recomendado)
- Postman (opcional, para realizar pruebas manuales)

## Cómo levantar el servidor

1. **Inicia el contenedor con Docker Compose:**

   Abre una terminal en el directorio raíz del proyecto y ejecuta:
   ```bash
   docker-compose up -d
   ```

   Esto levantará los servicios necesarios, incluyendo la base de datos PostgreSQL.

2. **Configura la base de datos:**

   Revisa el contenedor de Docker y verifica la base de datos `trainers`. Asegúrate de que el archivo de migración (gestionado con herramientas como `DBMate`) se haya ejecutado correctamente.

3. **Ejecuta la aplicación Spring Boot:**

   Desde tu IDE o terminal, ejecuta la aplicación Spring Boot. Esto inicializará el servidor en el puerto **3000**.

4. **Accede a la aplicación:**

   Abre tu navegador y dirígete a:
   ```
   http://localhost:3000
   ```

## Endpoints principales

### Pokémon

- **Listar información de un pokémon:**
  ```
  GET /pokemon/{id}
  ```
  - **Ejemplo:** `/pokemon/15` devuelve detalles como habilidades, evoluciones e información general del pokémon.

### Entrenadores

- **Visualizar un entrenador:**
  ```
  GET /trainer/{id}
  ```
  - **Ejemplo:** `/trainer/1` muestra información sobre un entrenador registrado.

## Pruebas del CRUD

Realiza pruebas en local utilizando Postman. Puedes verificar todas las funcionalidades del CRUD para pokémones y entrenadores. Aquí tienes algunas operaciones comunes:

- **Crear**: Añadir un nuevo recurso.
- **Leer**: Recuperar datos existentes.
- **Actualizar**: Modificar datos.
- **Eliminar**: Eliminar un recurso existente.

---


