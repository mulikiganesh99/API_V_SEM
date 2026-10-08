# Experiment 2 — Spring Modules
## Sub-question (a): Explore Spring Framework modules (Core, Data Access, Web)

### Aim
To explore Spring's Core Container, Data Access/Integration, and Web modules and demonstrate them together in one running application.

### Requirements
JDK 17+, Maven 3.9+, Spring Boot 3.3.4

### Project Structure
```
a_Explore_Spring_Modules/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   └── ModuleInfoController.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/DemoApplicationTests.java
```

### Dependencies Used
- `spring-boot-starter-web` (Web/MVC module) — **added**; the manual's dependency list for this sub-question only included `spring-boot-starter-jdbc`, `h2` and `test`, but the described goal explicitly includes the **Web** module, and the sample controller shown needs it to compile/run. See `ERRORS_AND_CORRECTIONS.md`.
- `spring-boot-starter-jdbc` (Data Access/Integration module)
- `com.h2database:h2` (runtime) — in-memory database backing the JDBC module
- `spring-boot-starter-test` (test scope)

### Explanation
- **Core Container**: demonstrated implicitly — `ModuleInfoController` and `DemoApplication` are both managed beans wired by Spring's IoC container.
- **Data Access/Integration**: `spring-boot-starter-jdbc` + H2 are on the classpath, auto-configuring a `JdbcTemplate` bean (exercised fully in sub-question b).
- **Web (MVC)**: `ModuleInfoController` is a `@RestController` exposing `/modules`.

### How to Run
```bash
mvn clean spring-boot:run
```

### API Endpoint
| Method | URL | Response |
|---|---|---|
| GET | http://localhost:8080/modules | Text summary of the three modules |

### curl Example
```bash
curl http://localhost:8080/modules
```

### Database Setup
H2 in-memory database `moduledb`, auto-created on startup; console at `http://localhost:8080/h2-console`.

### Common Errors & Fixes
- **`NoSuchBeanDefinitionException` for `DispatcherServlet`** → happens if `spring-boot-starter-web` is missing; it has been added to this pom for exactly that reason.

### Verification Steps
`mvn clean test` runs `contextLoads()`, confirming all three modules initialize without conflict.

### Manual Corrections Applied
See `ERRORS_AND_CORRECTIONS.md` — added the missing `spring-boot-starter-web` dependency.
