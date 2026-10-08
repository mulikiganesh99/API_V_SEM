# Experiment 3 — Autowiring and Logging
## Sub-question (d): Write a test class to verify auto-wiring and logging

*(Covers manual index item f.)*

### Aim
To write a `@SpringBootTest` that exercises both dependency injection and Logback-based logging (INFO + DEBUG levels) in one flow.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
d_Testing_AutoWiring_Logging/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/Employee.java
│   └── service/EmployeeService.java
├── src/main/resources/
│   ├── application.properties
│   └── logback-spring.xml
└── src/test/java/com/example/demo/EmployeeServiceTest.java
```

### Dependencies Used
`spring-boot-starter-web`, `spring-boot-starter-test`

### Explanation
This variant uses a slightly different `Employee` (int id, no department) matching the manual's test-focused code sample, with `com.example.demo` logger explicitly raised to `DEBUG` (with `additivity="false"` to avoid duplicate log lines from the root logger) in `logback-spring.xml`, so `logger.debug(...)` in `EmployeeService.displayEmployeeDetails()` is actually emitted.

### How to Run Tests
```bash
mvn clean test -Dtest=EmployeeServiceTest
```

### Expected Console Output (timestamp will differ)
```
... INFO  com.example.demo.service.EmployeeService - Fetching employee information via EmployeeService...
... DEBUG com.example.demo.service.EmployeeService - Employee instance details: Employee [ID=101, Name=John Doe]
Employee [ID=101, Name=John Doe]
```

### Common Errors & Fixes
- **DEBUG line missing from output** → confirm the `<logger name="com.example.demo" level="DEBUG" .../>` block is present in `logback-spring.xml`; the root logger alone is set to `INFO` and would otherwise suppress it.

### Verification Steps
`testAutoWiringAndLogging()` passing (no exceptions, context loads, injected bean is non-null since `employee.toString()` is safely called) confirms both autowiring and logging configuration work end-to-end.

### Manual Corrections Applied
None for this sub-question's own `logback-spring.xml` (it was already well-formed in the manual, unlike sub-question c/e's version) — only the earlier duplicated-`ref` bug (see sub-question c) was found and fixed there.
