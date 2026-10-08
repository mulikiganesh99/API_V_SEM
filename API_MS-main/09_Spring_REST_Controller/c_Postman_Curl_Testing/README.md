# Experiment 9 — Spring REST Controller
## Sub-question (c): Test the controller using Postman or curl

*(Covers manual index item e.)*

### Aim
Provide a runnable copy of the controller plus a concrete Postman/curl testing walkthrough with expected status codes.

### Requirements
JDK 17+, Maven 3.9+; Postman (optional)

### How to Run
```bash
mvn clean spring-boot:run
```

### Postman / curl Walkthrough
1. `GET http://localhost:8080/users` → `200`, 2 seeded users.
2. `POST http://localhost:8080/users` with body `{"name":"Diana Prince","email":"diana@example.com"}` → `201`.
3. `PUT http://localhost:8080/users/1` with body `{"name":"Rahul Updated","email":"rahul.updated@aditya.edu.in"}` → `200`.
4. `DELETE http://localhost:8080/users/2` → `200`.
5. `GET http://localhost:8080/users/2` (after step 4) → `404` (confirms the corrected error handling).

### curl Equivalents
```bash
curl -i http://localhost:8080/users
curl -i -X POST http://localhost:8080/users -H "Content-Type: application/json" -d '{"name":"Diana Prince","email":"diana@example.com"}'
curl -i -X PUT http://localhost:8080/users/1 -H "Content-Type: application/json" -d '{"name":"Rahul Updated","email":"rahul.updated@aditya.edu.in"}'
curl -i -X DELETE http://localhost:8080/users/2
curl -i http://localhost:8080/users/2
```

### Verification Steps
`mvn clean test` runs the same `UserControllerTest` suite as sub-question b against this copy.

### Manual Corrections Applied
Same 404-vs-500 fix as sub-question b.
