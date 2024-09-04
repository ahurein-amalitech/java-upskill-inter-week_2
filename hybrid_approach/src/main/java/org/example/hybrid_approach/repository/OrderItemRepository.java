package org.example.hybrid_approach.repository;

import org.example.hybrid_approach.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
