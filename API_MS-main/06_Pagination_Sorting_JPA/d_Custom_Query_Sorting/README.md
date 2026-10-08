# Experiment 6 — Pagination and Sorting with Spring Data JPA
## Sub-question (d): Implement custom sorting using @Query

### Aim
Define a custom JPQL query (`@Query("SELECT u FROM User u")`) that accepts a `Sort` parameter, letting Spring Data JPA append the `ORDER BY` clause dynamically.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
d_Custom_Query_Sorting/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/User.java
│   └── repository/UserRepository.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/UserCustomQueryTest.java
```

### How to Run Tests
```bash
mvn test -Dtest=UserCustomQueryTest
```

### Expected Console Output
```
--- STARTING CUSTOM @QUERY SORTING VERIFICATION TEST ---
[@QUERY SORT] Fetching raw output mapping results directly down below:
 -> Name: Vijay Sharma | Email: vijay@aditya.edu.in
 -> Name: Rahul Kumar | Email: rahul@aditya.edu.in
 -> Name: Deepak Verma | Email: deepak@aditya.edu.in
 -> Name: Bhavana Reddy | Email: bhavana@aditya.edu.in
 -> Name: Ananya Sen | Email: ananya@aditya.edu.in
--- CUSTOM @QUERY SORTING VERIFICATION TEST COMPLETED ---
```

### Common Errors & Fixes
- **`InvalidDataAccessApiUsageException` if `Sort` param is omitted from the method signature** → confirm `findAllUsersCustomSorted(Sort sort)` keeps its `Sort` parameter; Spring Data JPA only appends `ORDER BY` automatically for `@Query` methods when a trailing `Sort`/`Pageable` parameter is present.

### Verification Steps
`mvn test -Dtest=UserCustomQueryTest` — assertions confirm 5 results in descending name order (Vijay Sharma first, Ananya Sen last).

### Manual Corrections Applied
- Added a `@BeforeEach` data-seeding step and real JUnit assertions; the manual's version relied on data seeded by a separate test class (`UserPaginationTest`) running first in the same class-level Spring context, which is not reliable —  JUnit does not guarantee execution order between independent test classes/methods. Making each test class self-seeding (as done here) removes that inter-test dependency. See `ERRORS_AND_CORRECTIONS.md`.
