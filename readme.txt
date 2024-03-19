README - Aplicación de Gestión de Precios
Descripción General
Este proyecto implementa una solución back-end desarrollada con Spring Boot, diseñada para gestionar y consultar precios de productos en una base de datos de comercio electrónico. La funcionalidad principal se centra en un servicio web REST que permite consultar el precio aplicable a un producto en una fecha y hora específicas, considerando las tarifas de diferentes periodos y prioridades.

Funcionalidades
Consulta de Precios: Endpoint REST que recibe como parámetros la fecha de aplicación, el identificador de producto y el identificador de cadena, devolviendo el precio final a aplicar.
Tecnologías Empleadas
Spring Boot
H2 Database
Spring Data JPA
Maven
JUnit

Estructura del Proyecto
src/main/java: Contiene el código fuente de la aplicación.
modelo: Define la entidad JPA.
repositorio: Interfaz para el acceso a datos.
servicio: Servicio que contiene la lógica de negocio.
controlador: Controlador REST que expone el servicio web.
src/main/resources: Recursos de la aplicación, incluyendo la configuración de la base de datos H2.
Además podemos encontrar un fichero denominado data.sql en la que definimos la creación de la tabla PRICES y la inserción de datos en la misma. Este script .sql será lanzado de forma automática al ejecutar la aplicación.
src/test/java: Pruebas unitarias y de integración.

Cómo Correr el Proyecto
Requisitos
JDK 11+
Maven 3.6+
Podemos identificar las diferentes dependencias necesarias en el fichero de configuración pom.xml

Instrucciones
Clonar el repositorio a tu máquina local (https://github.com/adrisan93/TestComercioElectronico.git) o descargar el archivo ZIP y extraerlo.
Abrir una terminal y navegar al directorio del proyecto.
Ejecutar mvn clean install para compilar el proyecto y generar el archivo JAR.
Iniciar la aplicación con java -jar target/<nombre-del-artefacto>.jar.
Acceder a los endpoints a través de http://localhost:8080.
Mientras la aplicación esté arrancada podemos acceder a la consola de nuestra base de datos H2 a través del enlace http://localhost:8080/h2-console/
(Podemos ver las credenciales de acceso en el fichero de configuración application.properties de nuestro proyecto)

Cómo Ejecutar los Tests
Recomiendo configurar la codificacion de caracteres UTF-8 en nuestra consola antes de ejecutar los test.Para ello en la consola lanzar el comando chcp 65001.
Ejecutar mvn test en la terminal estando en el directorio del proyecto para correr las pruebas automatizadas, incluyendo pruebas unitarias y de integración.
Para verlo con mayor claridad podemos ver la ejecución de las pruebas en color verde.

Endpoint Detallado

GET /api/prices?date=YYYY-MM-DDTHH:MM:SS&productId=X&brandId=Y

YYYY-MM-DDTHH:MM:SS es la fecha y hora de consulta.
X es el identificador del producto.
Y es el identificador de la cadena.

Patrones de Diseño y Principios Utilizados
Para la implementación de la aplicación hemos optado por el patron de diseño Modelo-Vista-Controlador (MVC)
Modelo (Price.java): Representa la estructura de datos de la aplicación, definida por clases en Java que mapean las entidades de negocio y sus relaciones, facilitando la interacción con la base de datos.
Controlador (PriceController.java): Actúa como intermediario entre las vistas (o solicitudes HTTP) y los servicios, gestionando las interacciones del usuario, procesando las solicitudes y devolviendo las respuestas adecuadas.
Repositorio (PriceRepository.java): Es la capa de abstracción que permite la comunicación directa con la base de datos, utilizando Spring Data JPA para simplificar las operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre las entidades del modelo.
Servicio: Define la lógica de negocio (PriceService.java), encapsulando las operaciones específicas de la aplicación, trabajando entre los controladores y los repositorios para realizar tareas como consultas o actualizaciones de datos.
DTO (Data Transfer Object) (PriceResponse.java): Es un objeto que se utiliza para encapsular datos y enviarlos entre sub-sistemas de una aplicación, permitiendo transferir información sin exponer los modelos internos o la lógica de negocio.

Buenas Prácticas
Pruebas Unitarias y de Integración (PriceServiceTest.java): Aseguran el correcto funcionamiento de la aplicación y facilitan la detección temprana de errores.
Separación de Responsabilidades: División clara entre controladores, servicios y acceso a datos.
Manejo de Excepciones: Proporciona respuestas adecuadas ante errores en las peticiones.
Cabe destacar que el método del repositorio lo hemos llamado findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc para no tener que definir una query y aprovechar la potencia que proporciona el framework.
Sin embargo podemos definir una query mediante la etiqueta @Query

Creado por Adrián Sánchez con el objetivo de proporcionar una herramienta eficaz y eficiente para la gestión de precios en entornos de comercio electrónico.

