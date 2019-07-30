# KotlinAPISQL
Api con kotlin que accede a una base de datos MYSQL

Consideraciones:
- Se usa Clean Architecture, separando las capas de endpoints, casos de uso, repositorios.
- Se usa el patron comando en los casos de uso para dividir mejor las tareas.
- Se usa patron DTO para regresar los datos requeridos.
- Se usa el patron DAO para encapsular y ocultar el acceso a los datos.

Como probar:
- Cambiar la cadena de conexión y password en el archivo de application.properties.
- Hibernate se encarga de crear la base de datos.
- Accede por consola o un programa a la base de datos y ejecuta los siguentes comandos

Insert into accountdb.account(blood_type, date_last_query) values ('A+', '12/05/19')
Insert into accountdb.account(blood_type, date_last_query) values ('B+', '12/05/19')
Insert into accountdb.allergie(date, medicine, name, account_id) values ('12/05/19', 'ospirin 100mg', 'Rinitivis', 1);
Insert into accountdb.allergie( date, medicine, name, account_id) values ('12/05/20', 'Aspirina', 'Otra Alergia', 1);
Insert into accountdb.allergie(date, medicine, name, account_id) values ('12/05/19', 'ospirin 100mg', 'Rinitivis', 2)

Listo!! pronto actualizaciones....
