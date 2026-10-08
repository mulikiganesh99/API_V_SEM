# Experiment 4 — AOP Advices
## Sub-question (b): Student/StudentService — @Component and @Service

*(Covers manual index items b and c.)*

### Aim
Define `Student` (`@Component`) and `StudentService` (`@Service`, with `@Autowired Student`).

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
b_Student_StudentService/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/Student.java
│   └── service/StudentService.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/StudentServiceTest.java
```

### Dependencies Used
`spring-boot-starter-web`, `spring-boot-starter-aop`, `spring-boot-starter-test`.
`spring-boot-starter-aop` is included from this point on even though this sub-question alone doesn't use `@Aspect` yet, so the project is forward-compatible with sub-question c without a pom change — see `ERRORS_AND_CORRECTIONS.md` for why the manual's omission of this dependency (in the AOP sub-questions that actually need it) was a bug.

### How to Run
```bash
mvn clean spring-boot:run
```
(No output on its own — this sub-question doesn't have a `CommandLineRunner`; use `mvn clean test` to exercise it.)

### Verification Steps
```bash
mvn clean test
```
`StudentServiceTest.displayAndUpdateRunWithoutError` calls both service methods and confirms no exceptions — validating the `@Component`/`@Service`/`@Autowired` wiring.

### Manual Corrections Applied
None — the class code itself is correct.
