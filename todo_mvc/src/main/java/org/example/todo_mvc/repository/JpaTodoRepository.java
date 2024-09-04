package org.example.todo_mvc.repository;

import org.example.todo_mvc.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTodoRepository extends JpaRepository<Todo, Long> {
}
