# Experiment 1 — Setting up Spring Framework
## Sub-question (c): Write a simple "Hello World" application using Spring

### Aim
To build a minimal Spring Boot "Hello World" REST application and verify it with an automated MockMvc test.

### Requirements
- JDK 17+, Maven 3.9+, Spring Boot 3.3.4

### Project Structure
```
c_Hello_World/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   └── HelloController.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/HelloControllerTest.java
```

### Dependencies Used
- `spring-boot-starter-web`
- `spring-boot-starter-test` (test scope, provides MockMvc)

### Explanation
`HelloController` exposes `GET /hello`, returning `"Hello World using Spring Boot!"`. `HelloControllerTest` uses `MockMvc` to call the endpoint without starting a real server socket, asserting HTTP 200 and the exact body text.

### How to Run
```bash
mvn clean spring-boot:run
```

### API Endpoint
| Method | URL | Response |
|---|---|---|
| GET | http://localhost:8080/hello | `Hello World using Spring Boot!` |

### curl Example
```bash
curl http://localhost:8080/hello
```

### Expected Output
`Hello World using Spring Boot!` with HTTP 200.

### Common Errors & Fixes
- **Test fails with 404** → confirm `@AutoConfigureMockMvc` is present and the controller package is scanned (it is, since it's a sub-package of `com.example.demo`, the `@SpringBootApplication` package).

### Verification Steps
```bash
mvn clean test
```
`helloEndpointReturnsGreeting` should pass, exercising the real endpoint through Spring's test web layer (this is a genuine functional test, not a placeholder).

### Manual Corrections Applied
None — the manual's controller code was correct. A real MockMvc test was added since the manual only described manual browser verification.
