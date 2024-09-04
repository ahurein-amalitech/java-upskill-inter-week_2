package org.example.top_down_approach.repository;

import org.example.top_down_approach.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContaining(String title);
}
