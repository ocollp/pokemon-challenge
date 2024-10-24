package com.pokemon.service;

import com.pokemon.dto.PokemonDto;

import java.util.List;

public interface PokemonService {

    List<PokemonDto> findByNameStartsWith(String nameStartsWith);

    List<PokemonDto> findTopHeaviest(int limit);

    List<PokemonDto> findTopExperience(int limit);
}
