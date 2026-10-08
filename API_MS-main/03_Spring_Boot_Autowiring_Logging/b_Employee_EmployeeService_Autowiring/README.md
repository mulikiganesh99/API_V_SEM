# Experiment 3 — Autowiring and Logging
## Sub-question (b): Employee/EmployeeService — @Component, @Service, @Autowired

*(Covers manual index items b, c, and d together — "define the classes", "annotate them", and "wire them with @Autowired" are presented in the manual as a single implementation, so they are kept as one runnable project here rather than three artificial, non-functional intermediate ones.)*

### Aim
To implement Dependency Injection by defining `Employee` (`@Component`) and `EmployeeService` (`@Service`), wiring `Employee` into `EmployeeService` using field-level `@Autowired`.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
b_Employee_EmployeeService_Autowiring/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/Employee.java
│   └── service/EmployeeService.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/EmployeeServiceAutowiringTest.java
```

### Dependencies Used
`spring-boot-starter-web`, `spring-boot-starter-test`

### Explanation
- `Employee` is annotated `@Component`, making it an IoC-managed bean with pre-set sample fields.
- `EmployeeService` is annotated `@Service` and field-injects `Employee` via `@Autowired`.
- `DemoApplication` registers a `CommandLineRunner` bean that calls `employeeService.getEmployeeDetails()` on startup and prints it.

Field injection (rather than constructor injection) is used deliberately here because the lab explicitly asks students to "use `@Autowired` to inject Employee into EmployeeService" — constructor injection with `@Autowired` on Employee's constructor would also work, but the field-level form is what's being taught in this exercise.

### How to Run
```bash
mvn clean spring-boot:run
```

### Expected Console Output
```
Dependency Injection Successful: Employee [ID=250101, Name=Aditya Software Engineer, Dept=AI & ML Development]
```

### Common Errors & Fixes
- **`NoSuchBeanDefinitionException: Employee`** → verify `com.example.demo.model` is a sub-package of `com.example.demo` (the `@SpringBootApplication` package) so component scanning picks it up automatically.

### Verification Steps
```bash
mvn clean test
```
`EmployeeServiceAutowiringTest` asserts the injected `Employee`'s data appears in the service's output — a real functional check of the DI wiring, not just a context-loads smoke test.

### Manual Corrections Applied
None — the manual's Employee/EmployeeService code compiled and ran correctly.
