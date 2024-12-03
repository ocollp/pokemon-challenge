package com.pokemon.domain.shared.enums;

public enum ErrorEnum {
    POKEMON_NOT_FOUND("POKEMON-400-1", "Pokemon with id %s not found");

    private final String code;

    private final String message;

    ErrorEnum(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}