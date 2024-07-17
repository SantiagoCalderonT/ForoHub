# ForoHub | Alura Challenge

**ForoHub** es una aplicación web desarrollada en Java con Spring Boot para gestionar tópicos en un foro. Es mi solución para el desafío de programación de Oracle Next Education y  Alura. La aplicación permite a los usuarios autenticados crear, listar, actualizar y eliminar tópicos. Utiliza PostgreSQL como sistema de gestión de bases de datos y está diseñada siguiendo buenas prácticas de desarrollo de APIs REST.

## Características

- **Gestión de tópicos:** Permite crear, leer, actualizar y eliminar tópicos en el foro.
- **Autenticación de usuarios:** Solo los usuarios autenticados pueden interactuar con la API.
- **Persistencia de datos:** Utiliza PostgreSQL para almacenar la información.
- **Migraciones de base de datos:** Gestiona cambios en el esquema de la base de datos con Flyway.
- **Validación de datos:** Garantiza la calidad de los datos mediante validaciones.
- **Documentación de API:** Utiliza Swagger UI para explorar y probar los endpoints de la API.

## Tecnologías

- **Java:** Versión 21.
- **Maven:** Gestión de dependencias y construcción del proyecto.
- **Spring Boot:** Framework para desarrollar la aplicación. Versión 3.
- **PostgreSQL:** Sistema de gestión de bases de datos. Versión 16.
- **Flyway:** Migraciones de base de datos
- **Spring Security:** Seguridad y autenticación de usuarios

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes principales:

- **config**: Configuraciones de Spring Boot, incluyendo la configuración de seguridad.
- **controller**: Controladores REST que gestionan las solicitudes de la API.
- **model**: Clases de modelo que representan las entidades de la base de datos.
- **repository**: Repositorios para acceder a los datos en la base de datos.
- **service**: Lógica de negocio de la aplicación.
- **dto**: Clases de transferencia de datos (DTO) para las solicitudes y respuestas de la API.

## Modelo de la Base de Datos

![forohub_db](https://github.com/user-attachments/assets/98aefd21-e877-48e3-a9f1-90889c22cd86)



## Uso

Una vez que la aplicación esté en ejecución, puedes interactuar con la API a través de los siguientes endpoints:

- **POST** `/api/topics`: Crear un nuevo tópico.
- **GET** `/api/topics`: Listar todos los tópicos.
- **GET** `/api/topics/{id}`: Obtener los detalles de un tópico por ID.
- **PUT** `/api/topics/{id}`: Actualizar un tópico existente.
- **DELETE** `/api/topics/{id}`: Eliminar un tópico por ID.

## Comandos para Probar la API

Puedes probar los endpoints de la API usando herramientas como [Soap UI](https://www.soapui.org/) o [Postman](https://www.postman.com/).

### Ejemplos de Endpoints

- **Registrar un Tópico**:
    - **POST** `/topicos`
    - **Body**:
        ```json
        {
            "titulo": "Título del Tópico",
            "mensaje": "Mensaje del Tópico",
            "autor": "Autor del Tópico",
            "curso": "Curso del Tópico"
        }
        ```

- **Listar Tópicos**:
    - **GET** `/topicos`

- **Detalle de un Tópico**:
    - **GET** `/topicos/{id}`

- **Actualizar un Tópico**:
    - **PUT** `/topicos/{id}`
    - **Body**:
        ```json
        {
            "titulo": "Nuevo Título del Tópico",
            "mensaje": "Nuevo Mensaje del Tópico",
            "autor": "Nuevo Autor del Tópico",
            "curso": "Nuevo Curso del Tópico"
        }
        ```

- **Eliminar un Tópico**:
    - **DELETE** `/topicos/{id}`

