# Experiment 3 — Autowiring and Logging
## Sub-question (c): Configure logging using Logback

*(Covers manual index item e.)*

### Aim
To configure a custom `logback-spring.xml` console appender and emit SLF4J log statements from `EmployeeService`.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
c_Logback_Logging/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/Employee.java
│   └── service/EmployeeService.java
├── src/main/resources/
│   ├── application.properties
│   └── logback-spring.xml
└── src/test/java/com/example/demo/EmployeeServiceLoggingTest.java
```

### Dependencies Used
`spring-boot-starter-web` (brings SLF4J + Logback transitively via `spring-boot-starter-logging`), `spring-boot-starter-test`

### How to Run
```bash
mvn clean spring-boot:run
```

### Expected Console Output (timestamp will differ)
```
2026-09-27 10:00:00 [main] INFO  com.example.demo.service.EmployeeService - Executing operational details logging statement via Logback context.
2026-09-27 10:00:00 [main] INFO  com.example.demo.service.EmployeeService - Injected Object Reference Content: Employee [ID=250101, Name=Aditya Software Engineer, Dept=AI & ML Development]
```

### Common Errors & Fixes
- **`logback-spring.xml` fails to parse / app won't start ("Attribute 'ref' cannot be defined twice")** → this is a real bug present in the original manual: `<appender-ref ref="ref="CONSOLE" />` has a duplicated, malformed `ref` attribute, which is not well-formed XML and causes Logback to fail configuration at startup. **Fixed** to `<appender-ref ref="CONSOLE" />` here — see `ERRORS_AND_CORRECTIONS.md`.

### Verification Steps
```bash
mvn clean test
```
`EmployeeServiceLoggingTest.logDetailsRunsWithoutException` runs `logDetails()` inside the full Spring context; a clean pass proves both the DI wiring and the Logback configuration are valid (an invalid XML config file would make the context fail to start, failing this test).

### Manual Corrections Applied
- Fixed malformed `<appender-ref>` element in `logback-spring.xml` (duplicated `ref` attribute) that would otherwise prevent the application from starting. Full detail in `ERRORS_AND_CORRECTIONS.md`.
