# Experiment 3 — Autowiring and Logging
## Sub-question (a): Create a new Spring Boot project using Spring Initializr

### Aim
Bootstrap a bare Spring Boot 3.3.4 / Java 17 project as the base for the autowiring and logging exercises that follow.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
a_Create_Spring_Boot_Project/
├── pom.xml
├── src/main/java/com/example/demo/DemoApplication.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/DemoApplicationTests.java
```

### Dependencies Used
`spring-boot-starter-web`, `spring-boot-starter-test`

### How to Run
```bash
mvn clean spring-boot:run
```
Visiting `http://localhost:8080/` returns Spring Boot's default Whitelabel Error Page (HTTP 404/500 page) — expected, since no controller is defined yet; this confirms the server started.

### Verification Steps
`mvn clean test` — `contextLoads()` passes.

### Manual Corrections Applied
None.
