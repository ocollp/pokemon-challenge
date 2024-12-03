package com.pokemon.domain.shared.enums;

public enum ErrorEnum {
    POKEMON_NOT_FOUND("POKEMON-400-1", "Pokemon with id %s not found"),
    INVALID_REQUEST_PARAMETERS("POKEMON-400-2", "Invalid Required Input Parameters"),
    MISSING_HEADER("POKEMON-400-3", "Missing Required Header %s"),
    INVALID_BODY_REQUEST("POKEMON-400-4", "Invalid Body, the parameter %s has a invalid format %s"),
    FORBIDDEN("POKEMON-400-5", "Forbidden Access"),
    INTERNAL_SERVER_ERROR("POKEMON-500", "Internal Server Error");

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