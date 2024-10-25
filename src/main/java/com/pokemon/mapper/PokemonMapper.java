package com.pokemon.mapper;

import com.pokemon.dto.PokemonDto;
import com.pokemon.model.Pokemon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonMapper {

    PokemonDto toDto(Pokemon pokemon);

    Pokemon toEntity(PokemonDto pokemonDto);
}