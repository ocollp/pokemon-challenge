package com.pokemon.service;

import com.pokemon.dto.PokemonDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PokemonService {

    PokemonDto createPokemon(PokemonDto pokemon);

    List<PokemonDto> getAllPokemons();

    Optional<PokemonDto> getPokemonById(UUID id);

    Optional<PokemonDto> updatePokemon(UUID id, PokemonDto updatedPokemon);

    void deletePokemon(UUID id);

    List<PokemonDto> findByNameStartsWith(String nameStartsWith);

    List<PokemonDto> findTopHeaviest(int limit);

    List<PokemonDto> findTopExperience(int limit);
}
