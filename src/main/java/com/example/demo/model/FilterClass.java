package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FilterClass {
    public String field;

    public String value;

    public Enum<type> reqType;

    public enum type {
        EQ, LIKE, STARTS, GT, LT
    }
}
