package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final List<Product> productList = new ArrayList<>();
    private long currentId = 1;

    public ProductController() {
        productList.add(new Product(currentId++, "Laptop", 55000.0));
        productList.add(new Product(currentId++, "Smartphone", 25000.0));
    }

    // GET all — demonstrates a plain collection response
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productList);
    }

    // GET by id — demonstrates ResponseEntity with a dynamic status code (200 vs 404)
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST — demonstrates @RequestBody deserializing a JSON payload into a Product,
    // combined with ResponseEntity to set HTTP 201 Created and a Location header.
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
        newProduct.setId(currentId++);
        productList.add(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    // PUT — demonstrates @RequestBody for the updated payload, ResponseEntity for the result
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedData) {
        Optional<Product> existingOpt = productList.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (existingOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Product existing = existingOpt.get();
        existing.setName(updatedData.getName());
        existing.setPrice(updatedData.getPrice());
        return ResponseEntity.ok(existing);
    }

    // DELETE — demonstrates ResponseEntity<Void>/no-content style response
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean removed = productList.removeIf(p -> p.getId().equals(id));
        if (removed) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
