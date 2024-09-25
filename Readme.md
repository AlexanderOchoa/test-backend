# Prueba técnica backend - fullstack

## Pre-requisitos:

- Java JDK versión 17 a 21 (proyecto testeado con Eclipse Temurin versión 21.0.1)
- Docker para levantar BD Postgresql. Si tu computador no puede ejecutar docker, puedes instalar Postrgresql versión 14
- IDE para programar en Java

## Antes de iniciar

1.a Si utilizas Docker, instala la imagen desde la carpeta postgres-db, con el siguiente comando
``` 
docker-compose up
```
1.b Si no utilizas Docker:
- instala Postgres.
- user: user
- password: user

2. Si instalaste Postgres, o si al ejecutar docker-compose no se crea el schema test-backend:
- Crea el Schema "test-backend"

3. En el esquema test-backend, ejecuta el archivo sql ubicado en postgres-db/database.sql. La BD quedaría como se indica 
en la figura postgres-db/db.png.

4. Carga el proyecto en tu IDE favorito. El proyecto se ha testeado en Intellij y VsCode.

## Comentarios adicionales
- En ```src/main/resources/application.properties``` puedes cambiar la configuración del puerto, además del nombre del schema de la base de datos y credenciales (en caso de que ya tengas instalado Postgresql y no quieres cambiar tus credenciales).
