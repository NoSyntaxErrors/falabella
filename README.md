
# SpringBoot Application

##Falabella Offline Coding Evaluation

## Introducción

- Esta aplicación Spring usa Spring Web, Spring Data JPA, Lombok y Validation
- Se optó por el uso una Base de Datos H2, por lo que no necesita otro motor de base de datos, pero el cual si quisiera modificarse podria hacerse modificando los parametros del archivo application.properties, de esta manera para levantar la base de datos tanto la aplicación basta con ejecutar el .jar .
- El comando usado para levantar la aplicación sería java -jar "rutadelacarpeta"+store.jar o bien ejecutar desde el IDE a elección como una App de SpringBoot
### Endpoints

- Posee 5 endpoints distintos que forman un CRUD básico los cuales son:

- Ingreso de Producto
- Búsqueda del Producto por SKU
- Búsqueda de todos los Productos
- Actualización de un Producto según su SKU
- Eliminación de un Producto según su SKU

####Se incluye colección de Postman con la definición de los Endpoints antes mencionados.
