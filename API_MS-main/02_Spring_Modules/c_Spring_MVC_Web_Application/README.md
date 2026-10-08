# Experiment 2 — Spring Modules
## Sub-question (c): Create a web application using Spring MVC

### Aim
To build a Spring Web MVC application with a default route and a `@RequestParam`-driven dynamic route.

### Requirements
JDK 17+, Maven 3.9+, Spring Boot 3.3.4

### Project Structure
```
c_Spring_MVC_Web_Application/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── SpringMvcApplication.java
│   └── controller/PortalController.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/PortalControllerTest.java
```

### Dependencies Used
- `spring-boot-starter-web`
- `spring-boot-starter-test`

### How to Run
```bash
mvn clean spring-boot:run
```

### API Endpoints
| Method | URL | Response |
|---|---|---|
| GET | http://localhost:8080/ | `Welcome to Aditya University's Portal!` |
| GET | http://localhost:8080/greet?name=Aditya_Learner | `Greetings, Aditya_Learner! Welcome to your Spring Web MVC Dashboard.` |
| GET | http://localhost:8080/greet | `Greetings, Student! Welcome to your Spring Web MVC Dashboard.` (uses default) |

### curl Examples
```bash
curl http://localhost:8080/
curl "http://localhost:8080/greet?name=Aditya_Learner"
curl http://localhost:8080/greet
```

### Common Errors & Fixes
- **400 Bad Request on `/greet`** → cannot happen here since `defaultValue` is set on `@RequestParam`; if you remove the default, a missing `name` param would 400.

### Verification Steps
```bash
mvn clean test
```
Three MockMvc tests cover the default route, the parameterized route, and the default-value fallback.

### Manual Corrections Applied
None — the manual's controller code was correct as given.
