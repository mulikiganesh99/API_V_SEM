# Experiment 5 — Spring Data JPA
## Sub-question (b): Add Spring Data JPA dependency

### Aim
Add and verify `spring-boot-starter-data-jpa` + H2 on the classpath.

### Requirements
JDK 17+, Maven 3.9+

### Dependencies Used
`spring-boot-starter-web`, `spring-boot-starter-data-jpa`, `com.h2database:h2` (runtime), `spring-boot-starter-test`

### How to Run
```bash
mvn clean spring-boot:run
```
H2 console at `http://localhost:8080/h2-console` (JDBC URL `jdbc:h2:mem:testdb`).

### Verification
`mvn clean test` → `contextLoads()` confirms the `DataSource`/`EntityManagerFactory` beans auto-configure without error.

### Manual Corrections Applied
None.
