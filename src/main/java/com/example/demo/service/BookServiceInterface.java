package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookServiceInterface {
    Book addBook(Book book);

    List<Book> getAll();

    List<Book> getByTitle(String title);

    List<Book> getByPrice(double price);

    Book findById(int bookId) throws NoSuchFieldException;

    boolean updatePrice(int bookId, double price) throws NoSuchFieldException;

    boolean deleteById(int bookId);
}
