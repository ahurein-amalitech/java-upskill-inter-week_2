package org.example.big_bang_approach.repository;

import org.example.big_bang_approach.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByProduct_Id(int id);
}
