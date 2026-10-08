# Experiment 7 — RESTful Web Service
## Sub-question (d): Test using Postman or curl

### Aim
Provide a complete, ready-to-run copy of the CRUD service (identical to sub-question c) together with a full manual testing walkthrough for Postman/curl.

### Requirements
JDK 17+, Maven 3.9+; Postman (optional, GUI alternative to curl)

### How to Run
```bash
mvn clean spring-boot:run
```
The embedded Tomcat server starts listening on port 8080.

### Postman Collection Steps
1. **GET** `http://localhost:8080/api/users` → expect `200 OK`, JSON array of 2 seeded users.
2. **POST** `http://localhost:8080/api/users`, body (raw JSON):
   ```json
   { "name": "Charlie Brown", "email": "charlie@example.com" }
   ```
   → expect `201 Created`, response body echoes the new user with a generated `id`.
3. **PUT** `http://localhost:8080/api/users/1`, body:
   ```json
   { "name": "Alice Johnson", "email": "alice.johnson@example.com" }
   ```
   → expect `200 OK` with updated fields.
4. **DELETE** `http://localhost:8080/api/users/2` → expect `200 OK` with a confirmation message.
5. **GET** `http://localhost:8080/api/users/999` → expect `404 Not Found` (demonstrates the corrected error handling from sub-question c).

### curl Equivalents
```bash
curl -i http://localhost:8080/api/users
curl -i -X POST http://localhost:8080/api/users -H "Content-Type: application/json" -d '{"name":"Charlie Brown","email":"charlie@example.com"}'
curl -i -X PUT http://localhost:8080/api/users/1 -H "Content-Type: application/json" -d '{"name":"Alice Johnson","email":"alice.johnson@example.com"}'
curl -i -X DELETE http://localhost:8080/api/users/2
curl -i http://localhost:8080/api/users/999
```

### Expected HTTP Status Codes
`200` (GET/PUT/DELETE success), `201` (POST success), `404` (missing resource).

### Verification Steps
`mvn clean test` runs the same `UserControllerTest` suite as sub-question c against this copy of the service.

### Manual Corrections Applied
Same as sub-question c (404-vs-500 fix). The manual's original testing table (rendered as an embedded image, not machine-readable text) has been reproduced here as explicit curl/Postman steps with concrete expected status codes.
