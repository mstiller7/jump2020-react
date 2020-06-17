# NaviGreat 🧭

A **G**reat **N**avigation application, hybridized for desktop and mobile. Find your way around the office with nary a hassle!

![preview](https://i.imgur.com/pGQNlnz.png)

**Front-end (Javascript-based):**

* Build & Pack - [Expo](https://expo.io/)
* UI - [React](https://reactjs.org/), [React Native](https://reactnative.dev/)
* State - [Overmind](https://overmindjs.org/)

**Back-end (Java-based):**

* Build - Gradle
* Logic - Java 8, [Spring Boot](https://spring.io/projects/spring-boot)
* Database - [MongoDB](https://www.mongodb.com/)

***

## Development: Running

### Back-end

1. Ensure you have a MongoDB server running in your local environment. (The Spring Boot configuration assumes default settings; remap any necessary values in `backend/src/main/resources/application.properties` prior to compilation below.)
2. Then, compile the Java source files into JAR format, and run the application. Your server should be accessible at [localhost:8080](localhost:8080).
3. You can view the (initially empty) layout of the API by navigating to [localhost:8080/api](localhost:8080/api).

### Front-end

In the project root, run `expo start --web` to start up a development console in your web browser.
