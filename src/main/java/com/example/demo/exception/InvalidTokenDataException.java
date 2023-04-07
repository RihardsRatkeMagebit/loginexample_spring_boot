package com.example.demo.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidTokenDataException extends AuthenticationException {
    public InvalidTokenDataException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InvalidTokenDataException(String msg) {
        super(msg);
    }
}
