# JUGademy demo
A simple web application based on [Spring Boot](https://projects.spring.io/spring-boot/) presented by me on [JUGademy meetup](https://www.meetup.com/pl-PL/Poznan-Java-User-Group/events/238946503/).

## Running application
To start application go to root directory and type:
```bash
./gradlew bootRun
```
To browse it in web browser go to [http://localhost:8080/person-creator](http://localhost:8080/person-creator) URL.

The application uses [embedded MongoDB](https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo) as database so you don't need to install MongoDB on your own.
