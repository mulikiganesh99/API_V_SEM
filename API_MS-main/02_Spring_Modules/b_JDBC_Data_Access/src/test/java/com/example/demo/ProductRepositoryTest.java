package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void createInsertAndFindAllWorkAgainstH2() {
        productRepository.createTable();
        int rows = productRepository.save(new Product(999L, "Test Widget", 10.5));
        assertEquals(1, rows);

        List<Product> all = productRepository.findAll();
        assertTrue(all.stream().anyMatch(p -> p.getId().equals(999L) && "Test Widget".equals(p.getName())));
    }
}
