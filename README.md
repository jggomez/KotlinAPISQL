# KotlinAPISQL
Api con kotlin que accede a una base de datos MYSQL

Consideraciones:
- Se usa Clean Architecture, separando las capas de endpoints, casos de uso, repositorios.
- Se usa el patron comando en los casos de uso para dividir mejor las tareas.
- Se usa patron DTO para regresar los datos requeridos.
- Se usa el patron DAO para encapsular y ocultar el acceso a los datos.

Como probar:
- Cambiar la cadena de conexión y password en el archivo de application.properties.
- Ejecuta el programa hibernate se encarga de crear la base de datos.
- Accede por consola o por medio de un programa a la base de datos, asegurate que las tablas esten creadas y ejecuta el script que esta en el directorio de "src/main/resources".
- Invoca a las APIs:
  - localhost:8080/demo/v1/accounts/1
  - localhost:8080/demo/v1/accounts

Listo!! pronto actualizaciones....
