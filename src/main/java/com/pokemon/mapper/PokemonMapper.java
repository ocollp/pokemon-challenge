package com.pokemon.mapper;

import com.pokemon.dto.PokemonDto;
import com.pokemon.model.Pokemon;
import org.springframework.stereotype.Component;


@Component
public class PokemonMapper {

    public PokemonDto toDto(Pokemon pokemon) {
        if (pokemon == null) {
            return null;
        }
        return new PokemonDto(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getWeight(),
                pokemon.getBaseExperience()
        );
    }
}