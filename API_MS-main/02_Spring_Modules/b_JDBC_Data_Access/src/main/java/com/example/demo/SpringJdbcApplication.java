package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return args -> {
            System.out.println("--- Initializing H2 Database Schema ---");
            repository.createTable();

            System.out.println("--- Inserting Sample Product Records ---");
            repository.save(new Product(101L, "MacBook Pro", 129999.00));
            repository.save(new Product(102L, "Mechanical Keyboard", 4500.00));
            repository.save(new Product(103L, "Wireless Mouse", 1800.00));

            System.out.println("--- Querying Records from Database ---");
            List<Product> products = repository.findAll();
            for (Product p : products) {
                System.out.println(p.toString());
            }
        };
    }
}
