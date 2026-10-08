# Experiment 4 — AOP Advices
## Sub-question (a): Create a new Spring Boot project using Spring Initializr

### Aim
Bootstrap the base Spring Boot project for the AOP exercises.

### Requirements
JDK 17+, Maven 3.9+

### How to Run
```bash
mvn clean spring-boot:run
```

### Verification
`mvn clean test` → `contextLoads()` passes.

### Manual Corrections Applied
None for this bootstrap step (the dependency fix for AOP is documented starting from sub-question c, where `@Aspect` is first used).
