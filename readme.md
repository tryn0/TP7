# Trabajo Practico 7 [![Awesome](https://cdn.rawgit.com/sindresorhus/awesome/d7305f38d29fed78fa85652e3a63e154dd8e8829/media/badge.svg)](https://github.com/sindresorhus/awesome)

Este trabajo práctico ha sido realizado para el módulo de programación.

## Antes de ejecutar

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

## ¿Qué se ha usado?
Para este trabajo usamos JSON para leer el catálogo de productos y JDBC (Java Data Base Connectivity) para almacenar los pedidos en una base de datos.  
Para poder ejecutar correctamente esta trabajo es necesario tener dos archivo .jar que hará posible el uso de [JSON](http://central.maven.org/maven2/org/json/json/20180813/json-20180813.jar) y de [JDBC](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc/3.25.2).

## Fin
Este programa tiene el fin de guardar una lista de compras o factura de compras.  
Al ejecutar mostrará una serie de productos disponibles, de los cuales el cliente deberá elegir el deseado y la cantidad que desee.  
Una vez elegidos todos los productos, se mostrará el precio total por producto.  
Seguidamente nos dará la opción de visualizar la factura a través de una base de datos, donde se almacenan los datos de las facturas (persona, producto, cantidad, precio e ID).

## Autores
Robert Marius Puiu (Enlazamiento entre código, mejora y agregado de código adicional.)  
Guillermo Pérez Aragón (Aportación de clases y DAOs)

&copy;