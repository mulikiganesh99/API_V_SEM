# Experiment 9 — Spring REST Controller
## Sub-question (b): Create a REST controller (UserController) with CRUD operations

*(Covers manual index items c and d.)*

### Aim
Implement `UserController` at `/users` exposing full CRUD (GET all, GET by id, POST, PUT, DELETE) over an in-memory list.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
b_REST_Controller_CRUD/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/User.java
│   └── controller/UserController.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/UserControllerTest.java
```

### API Endpoints
| Method | URL | Body | Response |
|---|---|---|---|
| GET | /users | — | 200, JSON array |
| GET | /users/{id} | — | 200 + user JSON, or 404 |
| POST | /users | User JSON (no id) | 201 + created user JSON |
| PUT | /users/{id} | User JSON | 200 + updated user JSON, or 404 |
| DELETE | /users/{id} | — | 200 + message, or 404 |

### How to Run
```bash
mvn clean spring-boot:run
```

### curl Examples
```bash
curl http://localhost:8080/users
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d '{"name":"Diana Prince","email":"diana@example.com"}'
curl -X PUT http://localhost:8080/users/1 -H "Content-Type: application/json" -d '{"name":"Rahul Updated","email":"rahul.updated@aditya.edu.in"}'
curl -X DELETE http://localhost:8080/users/2
```

### Common Errors & Fixes
- **Manual bug — same as Experiment 7**: the manual's original controller threw a bare `RuntimeException` for a missing user, which Spring turns into an HTTP 500, not a proper 404. Fixed to return `ResponseEntity.notFound().build()` in every lookup path (GET-by-id, PUT, DELETE). See `ERRORS_AND_CORRECTIONS.md`.

### Verification Steps
```bash
mvn clean test
```
`UserControllerTest` runs a full create → read → update → delete → confirm-gone lifecycle via MockMvc.

### Manual Corrections Applied
- Same 404-vs-500 fix as Experiment 7c. See `ERRORS_AND_CORRECTIONS.md`.
