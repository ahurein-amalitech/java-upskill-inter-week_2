package org.example.top_down_approach.repository;

import org.example.top_down_approach.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
