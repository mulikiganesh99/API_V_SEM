# Experiment 5 — Spring Data JPA
## Sub-question (d): Create an entity class (User)

### Aim
Define `User` as a JPA `@Entity` mapped to a `users` table with an identity-generated primary key.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
d_Entity_User/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   └── model/User.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/UserEntityTest.java
```

### Explanation
`User` uses `jakarta.persistence.*` annotations (correct for Spring Boot 3.x, which is built on the Jakarta EE 9+ namespace, not the legacy `javax.persistence.*`). `@Id` + `@GeneratedValue(strategy = GenerationType.IDENTITY)` delegates primary-key generation to H2's auto-increment column.

### How to Run
```bash
mvn clean spring-boot:run
```
On startup, Hibernate DDL-auto creates the `users` table matching this entity (visible via `spring.jpa.show-sql=true` in the console log).

### Verification Steps
```bash
mvn clean test
```
`UserEntityTest` is a plain unit test (no Spring context needed) verifying the constructor and accessors.

### Manual Corrections Applied
None — the entity code (including the `jakarta.persistence` imports, correct for Spring Boot 3.x) was already correct.
