# Experiment 4 — AOP Advices
## Sub-question (c): Implement AOP advice using @Aspect and @Before

*(Covers manual index item d.)*

### Aim
To define `LoggingAspect`, a cross-cutting `@Aspect` component with a `@Before` advice that intercepts every method call on `StudentService`.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
c_AOP_Aspect_Before/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/Student.java
│   ├── service/StudentService.java
│   └── aspect/LoggingAspect.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/LoggingAspectTest.java
```

### Dependencies Used
- `spring-boot-starter-web`
- `spring-boot-starter-aop` — **added**. The manual's pom for the AOP experiment only ever lists `spring-boot-starter-web`, but `org.aspectj.lang.annotation.Aspect`/`@Before` and Spring AOP proxying require `spring-boot-starter-aop` (which pulls in AspectJ weaver + Spring AOP) on the classpath. Without it, the code in the manual would fail to compile (`org.aspectj.lang.annotation` would not resolve). This is documented as a correction in `ERRORS_AND_CORRECTIONS.md`.
- `spring-boot-starter-test`

### Explanation
`LoggingAspect` uses an AspectJ pointcut expression `execution(* com.example.demo.service.StudentService.*(..))` matching every method on `StudentService`, and a `@Before` advice that prints the intercepted method's name. `@EnableAspectJAutoProxy` on `DemoApplication` turns on proxy-based AOP.

### How to Run
```bash
mvn clean spring-boot:run
```
(No `CommandLineRunner` here — run the test below to see the advice fire, or add one as in sub-question d.)

### Verification Steps
```bash
mvn clean test
```
`LoggingAspectTest.beforeAdviceFiresOnServiceCall` calls `displayStudentDetails()`; check the console — an `[AOP-BEFORE] ... Triggering before: displayStudentDetails` line should appear immediately before the service's own `[Service Method]` line.

### Manual Corrections Applied
- Added the missing `spring-boot-starter-aop` Maven dependency, without which the `@Aspect`/`@Before` code shown in the manual cannot compile or run. See `ERRORS_AND_CORRECTIONS.md`.
