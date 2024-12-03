package com.pokemon.domain.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message, String format) {
        super(message);
    }
}