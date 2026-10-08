package com.example.demo;

import com.example.demo.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductModelTest {

    @Test
    void constructorAndAccessorsWork() {
        Product product = new Product(1L, "Laptop", 55000.0);
        assertEquals(1L, product.getId());
        assertEquals("Laptop", product.getName());
        assertEquals(55000.0, product.getPrice());
    }
}
