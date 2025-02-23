package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;

@RestController
public class BookRestController {
    
    @Autowired
    private BookRepository repository;
    
    // RESTful service to get all books
    @GetMapping("/api/books")
    public List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }
    
    // RESTful service to get book by id
    @GetMapping("/api/books/{id}")
    public Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId);
    }
}
