# Trabajo Práctico 7 [![Awesome](https://cdn.rawgit.com/sindresorhus/awesome/d7305f38d29fed78fa85652e3a63e154dd8e8829/media/badge.svg)](https://github.com/sindresorhus/awesome)

Este trabajo práctico ha sido realizado para el módulo de programación.

## Antes de ejecutar:

Usar [javac](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) para compilar.  
[Aquí](http://somebooks.es/instalar-jdk-windows-10/) dejo un tutorial para poder tener listo el compilador en Windows 10.

Para poder compilar y ejecutar el proyecto se tiene que tener las variables de entorno preparadas, para ello, sino se tiene ya configurado, hay un link a un tutorial.  
**Para ejecutarlo ponemos este comando para Linux:**
```bash
$ javac -cp .:json-20180813.jar:sqlite-jdbc-3.25.2.jar:. tienda.java  
$ java -cp .:json-20180813.jar:sqlite-jdbc-3.25.2.jar:. tienda
```
**Y para Windows:**
```bash
javac -cp .;json-20180813.jar;sqlite-jdbc-3.25.2.jar;. tienda.java  
java -cp .;json-20180813.jar;sqlite-jdbc-3.25.2.jar;. tienda
```
Ejcutar a través de la línea de comandos de Windows o de la terminal de linux.
## Para la base de datos:
En el proyecto, existe un fichero inicial que se llama compra.db, que ya lleva introducida la base de datos y la tabla.

**¿Que hacer en caso de no tener dicho fichero?**  
Si no existe el fichero en la raiz del programa, este debe ser creado y llamado compra.db.  
En Linux:
```bash
$ javac -cp .:json-20180813.jar:sqlite-jdbc-3.25.2.jar:. JDBC.java  
$ java -cp .:json-20180813.jar:sqlite-jdbc-3.25.2.jar:. JDBC
```
En Windows:
```bash
javac -cp .;json-20180813.jar;sqlite-jdbc-3.25.2.jar;. JDBC.java  
java -cp .;json-20180813.jar;sqlite-jdbc-3.25.2.jar;. JDBC
```
Una vez hecho esto se creará el fichero compra.db, listo su uso.
## ¿Qué se ha usado?
Para este trabajo usamos JSON para leer el catálogo de productos y JDBC (Java Data Base Connectivity) para almacenar los pedidos en una base de datos.  
Para poder ejecutar correctamente esta trabajo es necesario tener dos archivo .jar que hará posible el uso de [JSON](http://central.maven.org/maven2/org/json/json/20180813/json-20180813.jar) y de [JDBC](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc/3.25.2).

## Contenido del proyecto:

Tienda.java     --> Es la clase principal, cuyo funcionamiento se explica más adelante.

Compra.java     --> Crea un objeto compra, que contiene la clase Articulo, y la clase Persona implementadas.

Articulo.java   --> Objeto articulo, que contiene el nombre y el precio del articulo.

Person.java     --> Objeto persona, que contiene el nombre de una persona.

DAOCompra.java  --> Interface que se usará para hacer implementaciones de base de datos.

JDBCCompra.java --> Contiene métodos para conectarse a la bd, para grabar, y para consultar la base de datos.

JDBC.java       --> Sirve para crear la tabla "compra".

productos.json  --> Aquí se guarda el catálogo de compras, en formato json.

compra.db       --> Es el fichero de base de datos, que contiene la tabla "compra".

## Fin:
Este programa tiene el fin de guardar una lista de compras o factura de compras.  
Al ejecutar mostrará una serie de productos disponibles, de los cuales el cliente deberá elegir el deseado y la cantidad que desee. 

Una vez elegidos todos los productos, se mostrará el precio total por producto.  
Seguidamente nos dará la opción de visualizar la factura a través de una base de datos, donde se almacenan los datos de las facturas (persona, producto, cantidad, precio e ID).

## ¿Cómo funciona?
En un principio, el programa Tienda.java coge informacion del fichero json, para asi poseer un catalogo de productos permitidos, que contienen nombre y precio. Una vez obtenido el catalogo, el programa hace una nueva compra(ahi es donde entran las clases Articulo,Compra, y Person), y empieza a pedir datos por teclado, para definir dicha compra(nombre de la persona, que articulo se quiere comprar, etc..).  

El programa es capaz de que una persona, pueda tener uno o mas articulos, y tambien puede tener una o mas compras(que estan distribuidos por ID) por lo que, se pueden repetir nombres en las personas.Cada vez que se hace una entrada, al finalizar, el programa guarda la informacion en la base de datos del fichero compra.db(aqui es donde se empieza a usar El fichero DAOCompra, y su implementación). 

Una vez que ya se acaban con las entradas, existe la posibilidad de consultar los datos. Al ir por ese camino, se muestra un listado completo, mostrando todos los datos que hay guardados en la base de datos, y despues de eso, te ofrece 3 posibilidades: Consultar por nombre, Consultar por producto, y consultar por ID de compra. Finalmente, cuando ya no se quiere consultar mas, finaliza el programa.

## Cambios:
Los cambios para la v0.2:  
-Se le ha añadido fecha y hora a la factura de la compra, tanto a la clase Compra como a la compra guardada en la base de datos compra.db.  
-Pequeñas mejoras de código.

## Autores:
Robert Marius Puiu (Enlazamiento entre código, mejoras y agregado de código adicional.)  
Guillermo Pérez Aragón (Aportación de clases, DAOs, fechas y mejoras de código.)

&copy;
