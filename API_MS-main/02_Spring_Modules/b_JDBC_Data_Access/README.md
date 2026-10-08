# Experiment 2 — Spring Modules
## Sub-question (b): Implement a simple data access application using Spring JDBC

### Aim
To implement CRUD-style data access using `JdbcTemplate` against an in-memory H2 database, seeded via a `CommandLineRunner`.

### Requirements
JDK 17+, Maven 3.9+, Spring Boot 3.3.4

### Project Structure
```
b_JDBC_Data_Access/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── SpringJdbcApplication.java
│   ├── model/Product.java
│   └── repository/ProductRepository.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/ProductRepositoryTest.java
```

### Dependencies Used
- `spring-boot-starter-jdbc`
- `com.h2database:h2` (runtime)
- `spring-boot-starter-test`

### Explanation
`ProductRepository` uses `JdbcTemplate` (constructor-injected) to create the `products` table and run raw SQL `INSERT`/`SELECT` statements, mapping rows to `Product` via a custom `RowMapper`. `SpringJdbcApplication`'s `CommandLineRunner` bean creates the table, inserts three sample products, and prints them on startup.

### How to Run
```bash
mvn clean spring-boot:run
```

### Expected Console Output
```
--- Initializing H2 Database Schema ---
--- Inserting Sample Product Records ---
--- Querying Records from Database ---
Product{id=101, name='MacBook Pro', price=129999.0}
Product{id=102, name='Mechanical Keyboard', price=4500.0}
Product{id=103, name='Wireless Mouse', price=1800.0}
```

### Database Setup
H2 in-memory `testdb`, created automatically at startup by `ProductRepository.createTable()`. Console: `http://localhost:8080/h2-console`.

### Common Errors & Fixes
- **`BadSqlGrammarException: table "PRODUCTS" not found`** → `createTable()` must run before `save()`/`findAll()`; the `CommandLineRunner` already sequences this correctly — don't call the repository from elsewhere before the runner executes.
- **Duplicate key on re-run of the packaged jar** → H2 `mem:` databases reset on every JVM restart, so re-running is always safe (each run gets a fresh empty database).

### Verification Steps
```bash
mvn clean test
```
`ProductRepositoryTest.createInsertAndFindAllWorkAgainstH2` is a **real** JDBC integration test — it creates the table, inserts a row, and asserts it comes back from `findAll()`.

### Manual Corrections Applied
None — the manual's JDBC code compiled and ran correctly as written; only a genuine test was added (the manual only showed a console-output demo, not an automated test).
