package com.pokemon.domain.factory;

import com.pokemon.domain.entity.Pokemon;
import com.pokemon.domain.shared.dto.PageDTO;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PokemonFactory {

    public static final UUID ID_FIRE = UUID.randomUUID();
    public static final String NAME_FIRE = "Charmander";
    public static final double WEIGHT_FIRE = 8.5;
    public static final int BASE_EXPERIENCE_FIRE = 113;

    public static final UUID ID_WATER = UUID.randomUUID();
    public static final String NAME_WATER = "Squirtle";
    public static final double WEIGHT_WATER = 9.0;
    public static final int BASE_EXPERIENCE_WATER = 94;

    public static final UUID ID_PLANT = UUID.randomUUID();
    public static final String NAME_PLANT = "Bulbasaur";
    public static final double WEIGHT_PLANT = 6.9;
    public static final int BASE_EXPERIENCE_PLANT = 64;

    public static final String POKEMON_FIRE_NAME_UPDATED = "Charmander Updated";
    public static final String POKEMON_NAME_STARTS_WITH = "Cha";
    public static final String POKEMON_NOT_FOUND_CODE = "POKEMON-400-1";

    public static final Pokemon POKEMON_FIRE = Pokemon.builder().id(ID_FIRE).name(NAME_FIRE).weight(WEIGHT_FIRE).baseExperience(BASE_EXPERIENCE_FIRE).build();
    public static final Pokemon POKEMON_WATER = Pokemon.builder().id(ID_WATER).name(NAME_WATER).weight(WEIGHT_WATER).baseExperience(BASE_EXPERIENCE_WATER).build();
    public static final Pokemon POKEMON_PLANT = Pokemon.builder().id(ID_PLANT).name(NAME_PLANT).weight(WEIGHT_PLANT).baseExperience(BASE_EXPERIENCE_PLANT).build();
    public static final Pokemon POKEMON_FIRE_UPDATED = Pokemon.builder().id(ID_FIRE).name(POKEMON_FIRE_NAME_UPDATED).weight(WEIGHT_FIRE).baseExperience(BASE_EXPERIENCE_FIRE).build();

    public static final List<Pokemon> POKEMON_LIST = Arrays.asList(POKEMON_FIRE, POKEMON_WATER, POKEMON_PLANT);
    public static final PageDTO<List<Pokemon>> POKEMON_PAGE = PageDTO.<List<Pokemon>>builder().content((POKEMON_LIST)).totalElements(List.of(POKEMON_LIST).size()).build();
}