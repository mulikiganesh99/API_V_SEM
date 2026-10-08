# Experiment 1 — Setting up Spring Framework
## Sub-question (b): Configure the project structure and dependencies

### Aim
To configure a layered project structure (`controller/`, `service/`, `repository/`, `model/`) and wire up Web + Data JPA + H2 dependencies in `pom.xml` and `application.properties`.

### Requirements
- JDK 17+, Maven 3.9+, Spring Boot 3.3.4

### Project Structure
```
b_Project_Structure_Dependencies/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   └── controller/HelloController.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/DemoApplicationTests.java
```
(`service/`, `repository/`, `model/` packages are created empty, as placeholders for future layers, matching the manual's structure — Java does not require a package directory to contain a file to be a valid package once classes are added later.)

### Dependencies Used
- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `com.h2database:h2` (runtime scope)
- `spring-boot-starter-test` (test scope)

The manual additionally listed `org.projectlombok:lombok` as "optional". It was **removed** here since no class in this sub-question uses any Lombok annotation — an unused dependency adds build weight and risk of annotation-processor misconfiguration with no benefit (see `ERRORS_AND_CORRECTIONS.md`).

### Application Properties
See `src/main/resources/application.properties` — configures the H2 in-memory datasource, Hibernate DDL auto-update, and the H2 web console.

### How to Run
```bash
mvn clean spring-boot:run
```

### API Endpoints
| Method | URL | Response |
|---|---|---|
| GET | http://localhost:8080/test | `Project Configured Successfully` |

Also available: H2 console at `http://localhost:8080/h2-console` (JDBC URL `jdbc:h2:mem:testdb`, user `sa`, empty password).

### curl Example
```bash
curl http://localhost:8080/test
```

### Expected Output
`Project Configured Successfully` with HTTP 200.

### Common Errors & Fixes
- **H2 console shows "Database not found"** → the JDBC URL entered in the console must exactly match `spring.datasource.url` (`jdbc:h2:mem:testdb`).
- **Lombok annotation processor errors** → not applicable here since Lombok was removed; if you re-add it, ensure your IDE has annotation processing enabled.

### Verification Steps
1. `mvn clean test` passes.
2. `/test` returns the expected string.
3. Visit the H2 console and confirm you can log in with the configured URL/credentials.

### Manual Corrections Applied
- Removed the unused Lombok dependency (no code uses it in this sub-question) — see `ERRORS_AND_CORRECTIONS.md`.
