# Spring Boot demo
A simple web application based on [Spring Boot](https://projects.spring.io/spring-boot/) presented by me on [JUGademy meetup](https://www.meetup.com/pl-PL/Poznan-Java-User-Group/events/238946503/).

## Running application
To start the application go to the root directory and type:
```
./gradlew bootRun
```
To view it in a web browser go to a [http://localhost:8080/persons-creator](http://localhost:8080/person-creator) URL.

The application uses [embedded MongoDB](https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo) as database so you don't need to install MongoDB on your own.

## Running automatic test
To run test download the [Firefox](https://www.mozilla.org/en-US/firefox/new/) web browser and the [geckodriver](https://github.com/mozilla/geckodriver/releases/tag/v0.15.0).
Install Firefox and unpack geckodriver executable file.
Now run test by typing:
```
./gradlew test -Dwebdriver.gecko.driver="Absolute path to geckodriver executable file"
```
The test is slowed down intentionally for demonstration purpose.
