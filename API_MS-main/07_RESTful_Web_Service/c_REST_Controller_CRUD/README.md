# Experiment 7 — RESTful Web Service
## Sub-question (c): Create a REST controller (UserController) & implement CRUD operations

*(Covers manual index items c and d, which the manual itself presents as one combined controller.)*

### Aim
Implement `UserController` at `/api/users` with full CRUD backed by an in-memory list.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
c_REST_Controller_CRUD/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/User.java
│   └── controller/UserController.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/UserControllerTest.java
```

### How to Run
```bash
mvn clean spring-boot:run
```

### API Endpoints
| Method | URL | Body | Response |
|---|---|---|---|
| GET | /api/users | — | 200, JSON array |
| GET | /api/users/{id} | — | 200 + user JSON, or 404 if missing |
| POST | /api/users | User JSON (no id) | 201 + created user JSON |
| PUT | /api/users/{id} | User JSON | 200 + updated user JSON, or 404 |
| DELETE | /api/users/{id} | — | 200 + message, or 404 |

### curl Examples
```bash
curl http://localhost:8080/api/users
curl http://localhost:8080/api/users/1
curl -X POST http://localhost:8080/api/users -H "Content-Type: application/json" \
  -d '{"name":"Charlie Brown","email":"charlie@example.com"}'
curl -X PUT http://localhost:8080/api/users/1 -H "Content-Type: application/json" \
  -d '{"name":"Rahul Updated","email":"rahul.updated@aditya.edu.in"}'
curl -X DELETE http://localhost:8080/api/users/2
```

### Common Errors & Fixes
- **Manual bug — GET/PUT/DELETE for a missing ID returned HTTP 500** — the original manual's `getUserById`/`updateUser`/`deleteUser` used `.orElseThrow(() -> new RuntimeException(...))`, which Spring Boot converts into an *unhandled* **HTTP 500 Internal Server Error** by default, not a proper `404 Not Found`. This is poor REST practice — a missing resource should be a 404, not a server error. **Fixed** here: every lookup now returns `ResponseEntity.notFound().build()` (404) when the user doesn't exist, and all endpoints return `ResponseEntity<T>` with explicit status codes (`200`, `201`, `404`). See `ERRORS_AND_CORRECTIONS.md`.

### Verification Steps
```bash
mvn clean test
```
`UserControllerTest` covers list retrieval, a genuine 404 case, and a full create→update→delete lifecycle via MockMvc — all real HTTP-layer tests, not placeholders.

### Manual Corrections Applied
- Replaced `RuntimeException`-based "not found" handling (which produced HTTP 500) with proper `ResponseEntity` 404 responses. See `ERRORS_AND_CORRECTIONS.md`.
