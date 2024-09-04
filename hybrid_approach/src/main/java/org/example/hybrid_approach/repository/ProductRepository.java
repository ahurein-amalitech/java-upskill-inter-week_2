package org.example.hybrid_approach.repository;

import org.example.hybrid_approach.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
