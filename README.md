# Casino API
[![anfegoca](https://circleci.com/gh/anfegoca/CasinoAPI.svg?style=svg)](https://app.circleci.com/pipelines/github/anfegoca/CasinoAPI)


Este programa ofrece es una API que representa un servicio de apuestas en ruletas, ofrece las siguientes funciones:

- **/createRoulette** : Permite la creación de nuevas ruletas, al usarlo devuelve el **id** de la nueva ruleta creada.
- **/openRoulette(id)** : Permite la apertura de una ruleta.
- **/betNumber(id,number,value)** (se debe enviar **userId** como header) : Permite apostar en una ruleta a un número determinado en nombre de un usuario.
- **/betColor(id,color,value)** (se debe enviar **userId** como header) : Permite apostar en una ruleta a un color determinado en nombre de un usuario.
- **/closeRoulette(id)** : Permite cerrar una ruleta y cobrar todas sus apuestas.
- **/getRoulettes** : Permite obtener todas las ruletas.
- **/deleteAll** : Permite eliminar todas las ruletas.

### Prerequisites

Para usar el proyecto se necesitan tener las siguientes versiones de java o superior:

```
java version "1.8"
javac version "1.8"
Apache Maven 3.6.3
```

## Getting Started

Para hacer uso del proyecto podemos clonar el repositorio o descargarlo directamente, para ejectarlo lo hacemos por medio de la consola usando el siguiente comando, para compilar las clases con maven

```bash
mvn package
```
Luego ejecutamos el programa usando el siguiente codigo:

Linux o Mac
```linux
java $JAVA_OPTS -cp target/classes:target/dependency/* co.casinoAPI.App
```
Windows
```windows
java -cp target/classes;target/dependency/* co.casinoAPI.App
```

luego abrimos la siguiente pagina: http://localhost:8080/<función>, nos aparecerá la siguiente página, donde podremos realizar las operaciones que queramos reemplazando
<función> por cualquiera de las funciones que se describieron anteriormente.

![img](https://github.com/anfegoca/CasinoAPI/blob/main/resources/1.png)

Tambien se puede crear un contenedor en Docker a partir del siguiente comando

```bash
docker pull anfegoca/casino-api:latest
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring-Boot](https://spring.io/projects/spring-boot) - Framework Web
* [Docker](https://www.docker.com/) - Deploy
* [Redis](https://redis.io/) - Persistence


## Versioning

El versionamiento se realizó a través de [github](https://github.com/anfegoca/CasinoAPI)

## Authors

* **Andrés González** - [anfegoca](https://github.com/anfegoca)


## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/anfegoca/CasinoAPI/blob/main/LICENSE) file for details

## Design

![design](https://github.com/anfegoca/CasinoAPI/blob/main/resources/Class%20Diagram.png)

La clase principal es **CasinoController**, es la que proporciona las funcionalidades de la **API**, cuando se va a crear una ruleta, representada por la clase **Roulette** se hace a través de la clase **RouletteFactory**, después se
usa la interfaz **RouletteService**, la cual es inyectada en la clase principal, obteniendo **RouletteServiceImp**, esta clase se comunica directamente con **RouletteRepository** la cual también es inyectada
y nos proporciona los servicios de persistencia con **redis**. Cuando se va a realizar una apuesta, representada en la clase **Bet**, ya que pueden ser de dos tipos, se usa **BetFactory**, la cual nos devuelve la apuesta que necesitamos
de acuerdo a los parámetros de entrada, para guardar la apuesta lo hacemos en la propiedad de apuestas de la ruleta. Para cobrar las apuestas simplemente le decimos a la misma apuesta
que cobre, para ello se implementó el método abstracto **collect**, que nos devolverá la factura que se genera después de cobrar la apuesta, para generar la factura, que es representada en la
clase **Bill**, lo hacemos con **BillFactory**.




