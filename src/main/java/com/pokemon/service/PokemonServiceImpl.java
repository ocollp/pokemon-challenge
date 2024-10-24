package com.pokemon.service;

import com.pokemon.dto.PokemonDto;
import com.pokemon.exception.PokemonNotFoundException;
import com.pokemon.mapper.PokemonMapper;
import com.pokemon.model.Pokemon;
import com.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonMapper pokemonMapper;

    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<PokemonDto> findByNameStartsWith(String prefix) {
        if (prefix == null || prefix.trim().isEmpty()) {
            return List.of();
        }

        List<Pokemon> pokemons = pokemonRepository.findByNameStartingWith(prefix.trim());

        if(pokemons.isEmpty()){
            throw new PokemonNotFoundException("No Pokémon found that start with: " + prefix);
        }

        return pokemons.stream()
                .map(pokemonMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PokemonDto> findTopHeaviest(int limit) {
        List<Pokemon> pokemons = pokemonRepository.findTop3ByOrderByWeightDesc();

        if (pokemons.isEmpty()) {
            throw new PokemonNotFoundException("No Pokémon found.");
        }

        return pokemons.stream()
                .map(pokemonMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PokemonDto> findTopExperience(int limit) {
        List<Pokemon> pokemons = pokemonRepository.findTop3ByOrderByBaseExperienceDesc();

        if (pokemons.isEmpty()) {
            throw new PokemonNotFoundException("No Pokémon found.");
        }

        return pokemons.stream()
                .map(pokemonMapper::toDto)
                .collect(Collectors.toList());    }
}
