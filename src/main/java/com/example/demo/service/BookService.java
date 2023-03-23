package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceInterface {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }


    // Simple version without search criteria
    // Not the best practice
    @Override
    public List<Book> getByTitle(String title) {
        List<Book> books = bookRepository.findAll();
        List<Book> result = new ArrayList<Book>();

        for (Book book : books){
            if (book.getTitle().equals(title)){
                result.add(book);
            }
        }

        return result;
    }

    // Simple version without search criteria
    // Not the best practice
    @Override
    public List<Book> getByPrice(double price) {
        List<Book> books = bookRepository.findAll();
        List<Book> result = new ArrayList<Book>();

        for (Book book : books){
            if (book.getCost() == price){
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public Book findById(int bookId) throws NoSuchFieldException {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            return book.get();
        } else {
            throw new NoSuchFieldException("book");
        }
    }

    @Override
    public boolean updatePrice(int bookId, double price) throws NoSuchFieldException {
        Book book = this.findById(bookId);
        book.setCost(price);
        this.addBook(book);

        return true;
    }

    @Override
    public boolean deleteById(int bookId) {
        this.bookRepository.deleteById(bookId);

        return true;
    }
}