package com.pokemon.application.rest.mappers;

import com.pokemon.client.dto.request.CreatePokemonRequest;
import com.pokemon.client.dto.request.PokemonRequest;
import com.pokemon.client.dto.response.PokemonResponse;
import com.pokemon.domain.entity.Pokemon;
import com.pokemon.domain.port.input.*;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PokemonMapper {
    List<PokemonResponse> toGetAllPokemonResponse(List<Pokemon> pokemonList);

    GetPokemonUseCase.InputValues toGetPokemonInputValues(UUID pokemonId);

    GetPokemonByNameStartUseCase.InputValues toGetPokemonByNameStart(UUID pokemonId);

    PokemonResponse toGetPokemonResponse(UUID pokemonId);

    @Mapping(target = "pokemon", source = "createPokemonRequest")
    CreatePokemonUseCase.InputValues toCreatePokemonInputValues(
            final CreatePokemonRequest createPokemonRequest);

    PokemonResponse toPokemonResponse(Pokemon pokemon);

    UpdatePokemonUseCase.InputValues toUpdatePokemonInputValues(PokemonRequest pokemonRequest);

    DeletePokemonUseCase.InputValues toDeletePokemonInputValues(UUID pokemonId);

    List<PokemonResponse> toGetPokemonListResponse(List<Pokemon> pokemon);

    GetTopHeaviestPokemonUseCase.InputValues toGetTopHeaviestPokemon(int limit);

    GetTopExperiencePokemonUseCase.InputValues toGetTopExperiencePokemon(int limit);
}