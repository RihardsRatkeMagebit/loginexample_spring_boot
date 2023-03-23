package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/book")
class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("list")
    public List<Book> list() {
        return bookService.getAll();
    }


    // Example without DTO (Data Transfer Object)
    @PostMapping("add")
    public boolean add(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "author") String author,
            @RequestParam(name = "price", required = false) double price
    ) {
        Book book = new Book();
        // Spring-boot doesn't support mongod DB auto generation ids
        // Simple example to generate ID, not best practice, just example
        Integer Id = (int) Math.floor(Math.random() * (10000000 - 1 + 1) + 1);
        book.setId(Id);
        book.setCost(price);
        book.setTitle(title);
        book.setAuthor(author);

        bookService.addBook(book);
        return true;
    }
}