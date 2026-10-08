# Experiment 6 — Pagination and Sorting with Spring Data JPA
## Sub-question (a): Create a repository interface with pagination methods

### Aim
Confirm that `JpaRepository` (which extends `PagingAndSortingRepository`) provides `findAll(Pageable)` out of the box, with no extra method declarations required.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
a_Repository_Pagination/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/User.java
│   └── repository/UserRepository.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/UserRepositoryPagingTest.java
```

### How to Run
```bash
mvn clean spring-boot:run
```

### Verification Steps
```bash
mvn clean test
```
`UserRepositoryPagingTest.findAllWithPageableReturnsAPage` inserts two users and requests page size 1, confirming exactly one result and a total-elements count ≥ 2.

### Manual Corrections Applied
- The manual's heading for this sub-question was mislabeled "Test CRUD operations" (a leftover header from Experiment 5) even though its actual content is about the pagination-ready repository interface. The folder/README here uses the correct index-table title. See `ERRORS_AND_CORRECTIONS.md`.
