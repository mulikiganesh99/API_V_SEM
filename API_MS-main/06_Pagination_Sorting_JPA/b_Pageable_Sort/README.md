# Experiment 6 — Pagination and Sorting with Spring Data JPA
## Sub-question (b): Use Pageable and Sort to implement pagination and sorting

### Aim
Implement `UserService.getUsersPagedAndSorted(...)`, building a `Sort` + `PageRequest` and delegating to `userRepository.findAll(pageable)`.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
b_Pageable_Sort/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/User.java
│   ├── repository/UserRepository.java
│   └── service/UserService.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/UserServiceTest.java
```

### How to Run
```bash
mvn clean spring-boot:run
```

### Verification Steps
```bash
mvn clean test
```
`UserServiceTest.serviceReturnsAscendingSortedPage` inserts "Zara" then "Aman" and confirms the returned page is sorted `Aman, Zara` — a genuine functional check of both pagination and sorting together.

### Manual Corrections Applied
None — the service logic was correct as given.
