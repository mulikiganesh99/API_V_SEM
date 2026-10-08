# Experiment 8 — SOAP Web Service
## Sub-question (c): Implement the service using @Service (UserServiceImpl)

### Aim
Implement `UserService` as `UserServiceImpl`, backed by an in-memory map of two seeded users.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
c_Service_Implementation/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/SoapUser.java
│   └── service/
│       ├── UserService.java
│       └── UserServiceImpl.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/UserServiceImplTest.java
```

### How to Run
```bash
mvn clean spring-boot:run
```

### Verification Steps
```bash
mvn clean test
```
`UserServiceImplTest` checks both a known ID (returns "Rahul Kumar") and an unknown ID (returns `null`) — real behavioral coverage, not a placeholder.

### Manual Corrections Applied
None — the manual's service implementation code was correct.
