# Experiment 10 — @RequestBody and ResponseEntity
## Sub-question (b): Full CRUD controller demonstrating @RequestBody and ResponseEntity

*(Covers manual index items b and c together — the manual itself implements both concepts inside one `ProductController` class, since every write endpoint needs `@RequestBody` and every endpoint returns `ResponseEntity`, so splitting them into two separate non-overlapping controllers would mean duplicating the same class. Both concepts are called out explicitly per-endpoint in code comments below.)*

### Aim
Implement `ProductController` demonstrating:
- **`@RequestBody`**: deserializing incoming JSON into a `Product` on `POST`/`PUT`.
- **`ResponseEntity`**: full control over HTTP status codes (`200`, `201`, `204`, `404`) and response bodies on every endpoint.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
b_RequestBody_ResponseEntity_CRUD/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/Product.java
│   └── controller/ProductController.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/ProductControllerTest.java
```

### API Endpoints
| Method | URL | Uses @RequestBody | ResponseEntity Status |
|---|---|---|---|
| GET | /api/products | No | 200 |
| GET | /api/products/{id} | No | 200 or 404 |
| POST | /api/products | **Yes** | 201 |
| PUT | /api/products/{id} | **Yes** | 200 or 404 |
| DELETE | /api/products/{id} | No | 204 or 404 |

### How to Run
```bash
mvn clean spring-boot:run
```

### curl Examples
```bash
curl http://localhost:8080/api/products
curl http://localhost:8080/api/products/1
curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d '{"name":"Headphones","price":3500.0}'
curl -X PUT http://localhost:8080/api/products/1 -H "Content-Type: application/json" -d '{"name":"Gaming Laptop","price":90000.0}'
curl -i -X DELETE http://localhost:8080/api/products/2
```

### Expected HTTP Status Codes
`200` (GET/PUT success), `201` (POST success), `204` (DELETE success, empty body), `404` (missing resource).

### Common Errors & Fixes
- **Manual bug — DELETE returned a bare `String` with implicit 200** in the original manual, which is inconsistent with typical REST convention (`204 No Content` for a successful delete with no body). **Fixed** here to `ResponseEntity<Void>` returning `204`. This also gives a cleaner demonstration of `ResponseEntity` covering a *body-less* success case, distinct from the `200`/`201` body-bearing cases elsewhere in the same controller. See `ERRORS_AND_CORRECTIONS.md`.
- **Manual bug — same 404-vs-500 issue as Experiments 7 and 9** (`RuntimeException` instead of proper 404 responses) — fixed the same way here.

### Verification Steps
```bash
mvn clean test
```
`ProductControllerTest` covers: default GET list, a real `@RequestBody` POST (with status + field assertions), a real `@RequestBody` PUT, and a DELETE followed by a 404 confirmation.

### Manual Corrections Applied
- DELETE now returns `204 No Content` instead of a `200` + string body, for correct REST semantics.
- Replaced `RuntimeException`-based 500 errors with proper `ResponseEntity` 404 responses.
See `ERRORS_AND_CORRECTIONS.md` for full detail.
