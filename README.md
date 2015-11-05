iw
==

Proyecto-plantilla para Ingeniería Web UCM, curso 2015-16

## Requisitos y dependencias

Este proyecto está pensado para ejecutarse sobre [Spring STS v3.6.1](https://spring.io/tools/sts/legacy). Probablemente funcione bien con versiones posteriores.

La plantilla rompe con la de un Spring MVC Proyect tradicional, y en su lugar usa [Spring Boot](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#getting-started) para 
- simplificar mucho la gestión de dependencias en el pom.xml
- permitir empaquetar la aplicación para uso sin servidor externo (vía `mvn clean package && java -jar target/iw-1.0.0-BUILD-SNAPSHOT.war`); es decir, genera `war` con tomcat embebido.
- simplificar mucho la configuración del acceso a BD (único fichero: `application.properties`)
- mejorar seguridad

## Uso

Puedes lanzarla de 3 formas:
- desde línea de comandos: `mvn clean package && java -jar target/iw-1.0.0-BUILD-SNAPSHOT.war`
- desde STS con el servidor embebido, vía `Run As > Spring Boot`
- desde STS con el servidor de STS, vía `Run As > Web app` (podrás cambiar JSPs, Controladores sin recargar)

Es fácil lanzar pruebas unitarias con `mvn test`:
- [sobre el controlador](https://github.com/manuel-freire/iw/blob/master/src/test/java/es/fdi/iw/model/SpringBootLauncherTests.java)
- [sobre la BD y objetos del modelo](https://github.com/manuel-freire/iw/blob/master/src/test/java/es/fdi/iw/model/UserTest.java)

Incluye un sistema de login relativamente seguro (aunque tendrás que verificar roles en la sesión / proteger contra CSRF manualmente).

## Incorporando la plantilla a un proyecto Spring MVC estándar

Descarga la plantilla usando git desde una línea de comandos:

     git clone https://github.com/manuel-freire/iw.git
     
Esto la descargará a una carpeta `iw`.

Asumiremos que estás en una carpeta en la que tienes `viejo` (tu código que no usa esta plantilla) e `iw` (la plantilla). Asumo que la estructura de paquetes es similar en ambos (`es.fdi.iw`) - modifica los comandos si no es así.
- cierra el STS, y borra sus ficheros (luego los regenerarás): `rm -rf viejo/.settings viejo/.classpath viejo/.project`
- copia los ficheros esenciales de la plantilla a tu proyecto `cp iw/pom.xml viejo && cp iw/src/main/webapp/WEB-INF/web.xml viejo/src/main/webapp/WEB-INF/ && cp -r iw/src/main/java/es/fdi/iw/*.java viejo/src/main/java/es/fdi/iw`
- modifica el `name` y el `artifactId` de tu proyecto editando tu pom.xml (están [en las líneas 6 y 7 ](https://github.com/manuel-freire/iw/blob/master/pom.xml#L6)), de forma que coincidan con el nombre que has elegido.
- mueve tu controlador de sitio: tiene que estar en un subpaquete de `es.fdi.iw`; recomiendo `es.fdi.iw.controller`
- ya puedes importar el proyecto en STS como un `maven project`.
- usa `meld` para incorporar aspectos del controlador de la plantilla en tu propio controlador: `meld iw viejo`; o pruebas unitarias, o lo que veas oportuno.
- modifica las clases del modelo (`es.fdi.iw.model`) a tu gusto

## Erratas y comentarios

Abre _issues_ si quieres que añada cosas concretas o ves errores; sube _pull requests_ si se te ocurre cómo añadirlas/solucionarlos (sube nota!).
