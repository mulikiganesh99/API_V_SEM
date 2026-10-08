# Experiment 5 — Spring Data JPA
## Sub-question (e): Create a repository interface (UserRepository)

### Aim
Define `UserRepository extends JpaRepository<User, Long>` to inherit standard CRUD operations.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
e_Repository_UserRepository/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/User.java
│   └── repository/UserRepository.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/UserRepositoryTest.java
```

### Explanation
`@Repository` on a Spring Data interface is optional (Spring Data automatically detects `JpaRepository` sub-interfaces) but kept here to match the manual and make the intent explicit.

### How to Run
```bash
mvn clean spring-boot:run
```

### Verification Steps
```bash
mvn clean test
```
`UserRepositoryTest.repositoryInheritsCrudMethods` saves a `User` and confirms it can be found by the generated ID — proving `save()`/`findById()` are correctly inherited and backed by a working `EntityManager`.

### Manual Corrections Applied
None.
