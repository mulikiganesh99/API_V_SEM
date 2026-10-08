package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository already extends PagingAndSortingRepository, so findAll(Pageable)
    // and findAll(Sort) are automatically available without any extra declarations.
}
