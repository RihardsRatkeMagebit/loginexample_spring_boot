package com.example.demo.dto;

import com.example.demo.model.Book;

public class BookDTO {
    public String title;
    public String author;
    public double cost;

    public BookDTO convert(Book book){
        title = book.getTitle();
        author = book.getAuthor().getName();
        cost = book.getCost();

        return this;
    }
}
