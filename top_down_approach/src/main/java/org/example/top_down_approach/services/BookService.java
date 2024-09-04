package org.example.top_down_approach.services;

import org.example.top_down_approach.entities.Book;
import org.example.top_down_approach.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> searchBooks(String query) {
        return bookRepository.findByTitleContaining(query);
    }
}
