# Experiment 8 — SOAP Web Service
## Sub-question (a): Create a new Spring Boot project for the SOAP web service

### Aim
Bootstrap the base project with Spring-WS on the classpath.

### Requirements
JDK 17+, Maven 3.9+

### Dependencies Used
- `spring-boot-starter-web-services` (Spring-WS: `MessageDispatcherServlet`, `@Endpoint` support)
- `wsdl4j` — required at runtime for `DefaultWsdl11Definition` to auto-generate a WSDL from an XSD
- `spring-boot-starter-test`

### How to Run
```bash
mvn clean spring-boot:run
```

### Verification
`mvn clean test` → `contextLoads()` passes.

### Manual Corrections Applied
None for this bootstrap step. The `wsdl4j` dependency (needed later, in sub-question d) is already included here so the pom doesn't need to change downstream — the manual didn't always list it explicitly next to the WSDL code, which would otherwise cause a runtime `ClassNotFoundException` for `com.ibm.wsdl.*` classes when generating the WSDL. See `ERRORS_AND_CORRECTIONS.md`.
