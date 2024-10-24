package com.pokemon.repository;

import com.pokemon.model.Pokemon;

import java.util.List;

public interface PokemonRepository {
    List<Pokemon> findByNameStartingWith(String nameStartsWith);
    List<Pokemon> findTop3ByOrderByWeightDesc();
    List<Pokemon> findTop3ByOrderByBaseExperienceDesc();
}

