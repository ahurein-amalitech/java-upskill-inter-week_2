package org.example.hybrid_approach.repository;

import org.example.hybrid_approach.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
