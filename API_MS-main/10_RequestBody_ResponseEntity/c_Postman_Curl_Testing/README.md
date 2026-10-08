# Experiment 10 — @RequestBody and ResponseEntity
## Sub-question (c): Test using Postman or curl

*(Covers manual index item d.)*

### Aim
Provide a runnable copy of the controller plus a concrete Postman/curl testing walkthrough.

### Requirements
JDK 17+, Maven 3.9+; Postman (optional)

### How to Run
```bash
mvn clean spring-boot:run
```

### Postman Steps
1. **GET** `http://localhost:8080/api/products` → `200`, 2 seeded products.
2. **POST** `http://localhost:8080/api/products`, raw JSON body:
   ```json
   { "name": "Headphones", "price": 3500.0 }
   ```
   → `201 Created`, response echoes the product with a generated `id`. This exercises `@RequestBody`.
3. **PUT** `http://localhost:8080/api/products/1`, body:
   ```json
   { "name": "Gaming Laptop", "price": 90000.0 }
   ```
   → `200 OK` with updated fields.
4. **DELETE** `http://localhost:8080/api/products/2` → `204 No Content` (empty body).
5. **GET** `http://localhost:8080/api/products/2` (after step 4) → `404 Not Found`.

### curl Equivalents
```bash
curl -i http://localhost:8080/api/products
curl -i -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d '{"name":"Headphones","price":3500.0}'
curl -i -X PUT http://localhost:8080/api/products/1 -H "Content-Type: application/json" -d '{"name":"Gaming Laptop","price":90000.0}'
curl -i -X DELETE http://localhost:8080/api/products/2
curl -i http://localhost:8080/api/products/2
```

### Verification Steps
`mvn clean test` runs the same `ProductControllerTest` suite as sub-question b against this copy.

### Manual Corrections Applied
Same as sub-question b (204-for-DELETE and 404-vs-500 fixes).
