package com.example.demo.model;

// MarianDB implementation

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "books")
public class Book {
    @Id
    private Integer id;

    @Transient
    public static final String SEQUENCE_NAME = "book_sequence";

    private String title;

    @Field(name = "price")

    private double cost;

    private Author author;
}
