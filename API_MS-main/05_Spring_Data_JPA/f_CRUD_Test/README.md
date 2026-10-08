# Experiment 5 — Spring Data JPA
## Sub-question (f): Test CRUD operations

### Aim
Exercise full Create/Read/Update/Delete against `UserRepository` backed by H2, with assertions on each step.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
f_CRUD_Test/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/User.java
│   └── repository/UserRepository.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/UserCrudTest.java
```

### How to Run Tests
```bash
mvn test -Dtest=UserCrudTest
```

### Expected Console Output (abridged)
```
================= INITIALIZING DATA JPA TESTS =================
Hibernate: insert into users ...
[CREATE] Success! ...
[READ ALL] Displaying existing user schema records below:
User{id=1, name='John Doe', email='john.doe@aditya.edu.in'}
User{id=2, name='Alice Smith', email='alice.s@aditya.edu.in'}
[UPDATE] Success! ...
User{id=1, name='John Developer', email='john.doe@aditya.edu.in'}
[DELETE] Terminated record row corresponding to Identifier Index ID: 2
[COUNT] Remaining Database Row Balance Vector Total: 1
================== DATA JPA TESTS COMPLETED ==================
```

### Common Errors & Fixes
- **Hardcoded `findById(1L)`/`findById(2L)` fails intermittently** → the original manual code hardcoded IDs `1L`/`2L`, which only works if H2's identity counter starts fresh at 1 for *every* run and no other test in the same Spring context has already inserted rows into `users`. This is fragile. **Fixed**: the test now captures and reuses the real generated IDs returned by `save()`, and calls `deleteAll()` at the start for a clean, deterministic baseline — see `ERRORS_AND_CORRECTIONS.md`.

### Verification Steps
`mvn test -Dtest=UserCrudTest` — all JUnit assertions (row count = 2 after create, name updated, row count = 1 after delete) must pass, in addition to the console narrative matching the manual's expected output.

### Manual Corrections Applied
- Replaced hardcoded `findById(1L)` / `deleteById(2L)` with IDs captured from the actual `save()` return values, and added `deleteAll()` at test start plus real JUnit assertions (the manual's version only printed to console with no assertions). See `ERRORS_AND_CORRECTIONS.md`.
