package com.pokemon.service;

import com.pokemon.dto.PokemonDto;
import com.pokemon.exception.PokemonNotFoundException;
import com.pokemon.mapper.PokemonMapper;
import com.pokemon.model.Pokemon;
import com.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;

    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository, PokemonMapper pokemonMapper) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonMapper = pokemonMapper;
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = pokemonMapper.toEntity(pokemonDto);
        Pokemon savedPokemon = pokemonRepository.save(pokemon);
        return pokemonMapper.toDto(savedPokemon);
    }

    @Override
    public List<PokemonDto> getAllPokemons() {
        return pokemonRepository.findAll().stream().map(pokemonMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<PokemonDto> getPokemonById(UUID id) {
        return pokemonRepository.findById(id).map(pokemonMapper::toDto);
    }

    @Override
    public Optional<PokemonDto> updatePokemon(UUID id, PokemonDto updatedPokemonDto) {
        return pokemonRepository.findById(id).map(pokemon -> {
            pokemon.setName(updatedPokemonDto.getName());
            pokemon.setWeight(updatedPokemonDto.getWeight());
            pokemon.setBaseExperience(updatedPokemonDto.getBaseExperience());
            return pokemonMapper.toDto(pokemonRepository.save(pokemon));
        });
    }

    @Override
    public void deletePokemon(UUID id) {
        pokemonRepository.deleteById(id);
    }

    @Override
    public List<PokemonDto> findByNameStartsWith(String prefix) {
        if (prefix == null || prefix.trim().isEmpty()) {
            return List.of();
        }

        List<Pokemon> pokemons = pokemonRepository.findByNameStartingWith(prefix.trim());

        if (pokemons.isEmpty()) {
            throw new PokemonNotFoundException("No Pokémon found that start with: " + prefix);
        }

        return pokemons.stream().map(pokemonMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PokemonDto> findTopHeaviest(int limit) {
        List<Pokemon> pokemons = pokemonRepository.findTop3ByOrderByWeightDesc();

        if (pokemons.isEmpty()) {
            throw new PokemonNotFoundException("No Pokémon found.");
        }

        return pokemons.stream().map(pokemonMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PokemonDto> findTopExperience(int limit) {
        List<Pokemon> pokemons = pokemonRepository.findTop3ByOrderByBaseExperienceDesc();

        if (pokemons.isEmpty()) {
            throw new PokemonNotFoundException("No Pokémon found.");
        }

        return pokemons.stream().map(pokemonMapper::toDto).collect(Collectors.toList());
    }
}
