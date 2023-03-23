package com.example.demo.exception;

public class NoSuchEntity extends RuntimeException {
    private String message;

    public NoSuchEntity(String type) {
        this.message = "Missing " + type;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
