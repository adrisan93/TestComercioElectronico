# TestComercioElectronico

## README - Aplicación de Gestión de Precios

### Descripción General
Este proyecto implementa una solución back-end desarrollada con **Spring Boot**, diseñada para gestionar y consultar precios de productos en una base de datos de comercio electrónico. La funcionalidad principal se centra en un servicio web REST que permite consultar el precio aplicable a un producto en una fecha y hora específicas, considerando las tarifas de diferentes periodos y prioridades.

### Funcionalidades
- **Consulta de Precios:** Endpoint REST que recibe como parámetros la fecha de aplicación, el identificador de producto y el identificador de cadena, devolviendo el precio final a aplicar.

### Tecnologías Empleadas
- Spring Boot
- H2 Database
- Spring Data JPA
- Maven
- JUnit

### Estructura del Proyecto
- `src/main/java`: Contiene el código fuente de la aplicación.
  - `modelo`: Define la entidad JPA.
  - `repositorio`: Interfaz para el acceso a datos.
  - `servicio`: Servicio que contiene la lógica de negocio.
  - `controlador`: Controlador REST que expone el servicio web.
- `src/main/resources`: Recursos de la aplicación, incluyendo la configuración de la base de datos H2.
  - Incluye un fichero `data.sql` para la creación de la tabla `PRICES` y la inserción de datos.
- `src/test/java`: Pruebas unitarias y de integración.

### Cómo Correr el Proyecto
**Requisitos**
- JDK 11+
- Maven 3.6+

**Instrucciones**
1. Clonar el repositorio a tu máquina local o descargar el archivo ZIP y extraerlo.
2. Abrir una terminal y navegar al directorio del proyecto.
3. Ejecutar `mvn clean install` para compilar el proyecto y generar el archivo JAR.
4. Iniciar la aplicación con `java -jar target/<nombre-del-jar>.jar`.
5. Acceder a los endpoints a través de `http://localhost:8080`.
6. La consola de la base de datos H2 está disponible en `http://localhost:8080/h2-console/`.

### Cómo Ejecutar los Tests
- Configurar la codificación de caracteres UTF-8 en la consola con `chcp 65001`.
- Ejecutar `mvn test` para correr las pruebas automatizadas.

### Endpoint Detallado
- GET /api/prices?date=YYYY-MM-DDTHH:MM:SS&productId=X&brandId=Y
- `YYYY-MM-DDTHH:MM:SS`: fecha y hora de consulta.
- `X`: identificador del producto.
- `Y`: identificador de la cadena.

### Patrones de Diseño y Principios Utilizados
- **Modelo-Vista-Controlador (MVC)**
  - **Modelo** (`Price.java`): Estructura de datos de la aplicación.
  - **Controlador** (`PriceController.java`): Gestiona las interacciones del usuario.
  - **Repositorio** (`PriceRepository.java`): Capa de abstracción para la comunicación con la base de datos.
  - **Servicio** (`PriceService.java`): Define la lógica de negocio.
  - **DTO** (`PriceResponse.java`): Objeto para transferir datos entre sub-sistemas de una aplicación.

### Buenas Prácticas
- **Pruebas Unitarias y de Integración** (`PriceServiceTest.java`): Aseguran el funcionamiento de la aplicación.
- **Separación de Responsabilidades**: División clara entre controladores, servicios y acceso a datos.
- **Manejo de Excepciones**: Proporciona respuestas adecuadas ante errores en las peticiones.

_Creado por Adrián Sánchez con el objetivo de proporcionar una herramienta eficaz y eficiente para la gestión._


