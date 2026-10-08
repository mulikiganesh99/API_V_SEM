# Experiment 4 — AOP Advices
## Sub-question (d): Apply AOP advice to StudentService methods

*(Covers manual index item e — the `@EnableAspectJAutoProxy` main-class wiring, now combined with a `CommandLineRunner` so the advice is visibly exercised at startup.)*

### Aim
To confirm the AOP proxy is actually applied to `StudentService` at runtime by invoking its methods from `DemoApplication`'s startup logic.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
d_Apply_Advice_Main_Config/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java   (adds @EnableAspectJAutoProxy + CommandLineRunner)
│   ├── model/Student.java
│   ├── service/StudentService.java
│   └── aspect/LoggingAspect.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/DemoApplicationTests.java
```

### Dependencies Used
`spring-boot-starter-web`, `spring-boot-starter-aop`, `spring-boot-starter-test`

### How to Run
```bash
mvn clean spring-boot:run
```

### Expected Console Output
```
[AOP-BEFORE] Intercepting execution route! Triggering before: displayStudentDetails
[Service Method] Core logic: Student name is John Doe with Roll Series: 251AI024
[AOP-BEFORE] Intercepting execution route! Triggering before: updateStudentName
[Service Method] Core logic: Modifying current name fields to: Alice Smith
```

### Verification Steps
`mvn clean test` (context-loads test) plus visual confirmation of the interleaved `[AOP-BEFORE]`/`[Service Method]` lines above when run via `spring-boot:run`.

### Manual Corrections Applied
Same `spring-boot-starter-aop` dependency fix as sub-question c (see `ERRORS_AND_CORRECTIONS.md`).
