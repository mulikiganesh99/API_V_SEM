# Experiment 6 — Pagination and Sorting with Spring Data JPA
## Sub-question (c): Test pagination and sorting functionality

### Aim
A dedicated integration test seeding 5 users and requesting page 0 / size 3, sorted ascending by name.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
c_Test_Pagination_Sorting/
├── pom.xml
├── src/main/java/com/example/demo/  (User, UserRepository, UserService, DemoApplication)
└── src/test/java/com/example/demo/UserPaginationTest.java
```

### How to Run Tests
```bash
mvn test -Dtest=UserPaginationTest
```

### Expected Console Output
```
--- STARTING PAGINATION AND SORTING VERIFICATION TEST ---
[PAGINATION] Total Elements found in H2 Store: 5
[PAGINATION] Total Pages compiled via segment metrics: 2
[PAGINATION] Content elements inside current window (Page 0):
 -> Name: Ananya Sen | Email: ananya@aditya.edu.in
 -> Name: Bhavana Reddy | Email: bhavana@aditya.edu.in
 -> Name: Deepak Verma | Email: deepak@aditya.edu.in
--- PAGINATION AND SORTING VERIFICATION TEST COMPLETED ---
```

### Verification Steps
The test includes real JUnit assertions (total elements = 5, total pages = 2, first result = "Ananya Sen") in addition to the console narrative — the manual's version only printed to console with no assertions, so assertions were added here for genuine verification.

### Manual Corrections Applied
- Added JUnit `assert*` calls (the manual's test only printed output with no pass/fail assertions). See `ERRORS_AND_CORRECTIONS.md`.
