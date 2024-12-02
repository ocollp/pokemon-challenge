package com.pokemon.client.utils;

public class RestConstants {

    private RestConstants() {
    }

    public static final String RESOURCE_POKEMON = "/pokemon";
    public static final String RESOURCE_TOP_HEAVIEST = "/top-heaviest";
    public static final String RESOURCE_TOP_EXPERIENCE = "/top-experience";

    public static final String PARAMETER_POKEMON_ID = "pokemonId";
    public static final String PARAMETER_POKEMON_NAME_STARTS_WITH = "nameStartsWith";
    public static final String PARAMETER_LIMIT = "limit";
}
