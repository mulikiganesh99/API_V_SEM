# Experiment 8 — SOAP Web Service
## Sub-question (b): Define a service interface (UserService)

### Aim
Define the `SoapUser` model and the `UserService` interface contract used by the SOAP endpoint.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
b_Service_Interface/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/SoapUser.java
│   └── service/UserService.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/DemoApplicationTests.java
```

### How to Run
```bash
mvn clean spring-boot:run
```
(No implementation yet — implemented in sub-question c.)

### Verification
`mvn clean test`

### Manual Corrections Applied
None.
