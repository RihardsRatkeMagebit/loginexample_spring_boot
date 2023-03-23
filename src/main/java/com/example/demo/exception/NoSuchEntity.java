package com.example.demo.exception;

public class NoSuchEntity extends RuntimeException {
    private String message;

    public NoSuchEntity(String type) {
        this.message = String.format("Entity with type %s Doesn't exist", type);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
