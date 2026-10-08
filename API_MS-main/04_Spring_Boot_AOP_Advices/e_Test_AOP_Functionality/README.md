# Experiment 4 — AOP Advices
## Sub-question (e): Write a test class to verify AOP functionality

*(Covers manual index item f.)*

### Aim
Formal JUnit verification that the `@Before` advice fires around `StudentService` method calls.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
e_Test_AOP_Functionality/
├── pom.xml
├── src/main/java/com/example/demo/  (same as sub-question d)
└── src/test/java/com/example/demo/StudentAopTest.java
```

### Dependencies Used
`spring-boot-starter-web`, `spring-boot-starter-aop`, `spring-boot-starter-test`

### How to Run Tests
```bash
mvn test -Dtest=StudentAopTest
```

### Expected Console Log
```
====== SYSTEM TEST INITIALIZATION ======
[AOP-BEFORE] Intercepting execution route! Triggering before: displayStudentDetails
[Service Method] Core logic: Student name is John Doe with Roll Series: 251AI024
=========================================
[AOP-BEFORE] Intercepting execution route! Triggering before: updateStudentName
[Service Method] Core logic: Modifying current name fields to: Alice Smith
========= SYSTEM TEST COMPLETED =========
```

### Verification Steps
The test passing (no exceptions) plus the interleaved AOP/service console lines together confirm the aspect is correctly woven into the Spring-managed `StudentService` proxy.

### Manual Corrections Applied
Same `spring-boot-starter-aop` dependency fix noted in sub-questions c and d.
