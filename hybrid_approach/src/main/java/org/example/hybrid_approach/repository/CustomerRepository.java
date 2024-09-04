package org.example.hybrid_approach.repository;

import org.example.hybrid_approach.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
