package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS products(id BIGINT PRIMARY KEY, name VARCHAR(255), price DOUBLE)";
        jdbcTemplate.execute(sql);
    }

    public int save(Product product) {
        String sql = "INSERT INTO products (id, name, price) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, product.getId(), product.getName(), product.getPrice());
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    private static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            return product;
        }
    }
}
