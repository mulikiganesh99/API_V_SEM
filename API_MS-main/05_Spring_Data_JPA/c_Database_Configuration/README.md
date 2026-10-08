# Experiment 5 — Spring Data JPA
## Sub-question (c): Configure database connection properties

### Aim
Configure H2 datasource URL, dialect, DDL strategy, SQL logging, and the H2 web console.

### Requirements
JDK 17+, Maven 3.9+

### Application Properties
See `src/main/resources/application.properties` — sets `spring.datasource.*`, `spring.jpa.database-platform`, `spring.jpa.hibernate.ddl-auto=update`, `spring.jpa.show-sql=true`, `spring.h2.console.enabled=true`.

### How to Run
```bash
mvn clean spring-boot:run
```

### Database Setup
In-memory H2 `testdb`; no external setup needed. Console at `http://localhost:8080/h2-console`.

### Verification
`mvn clean test` → `contextLoads()` passes, proving all datasource/JPA properties are valid.

### Manual Corrections Applied
None — the property values in the manual were valid.
