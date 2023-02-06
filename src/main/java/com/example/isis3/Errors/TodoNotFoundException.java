package com.example.isis3.Errors;

public class TodoNotFoundException extends Error {
    public TodoNotFoundException(String message) {
        super(message);
    }
}
