package com.pokemon.controller;

import com.pokemon.exception.PokemonNotFoundException;
import com.pokemon.exception.GlobalErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<GlobalErrorResponse> handlePokemonNotFound(PokemonNotFoundException ex) {
        GlobalErrorResponse errorResponse = new GlobalErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalErrorResponse> handleGenericException(Exception ex) {
        GlobalErrorResponse errorResponse = new GlobalErrorResponse();
        errorResponse.setMessage("An unexpected error occurred: " + ex.getMessage());
        errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
