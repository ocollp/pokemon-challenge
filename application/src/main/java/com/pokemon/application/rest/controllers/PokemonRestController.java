package com.pokemon.application.rest.controllers;

import com.pokemon.application.rest.mappers.PokemonMapper;
import com.pokemon.client.dto.request.CreatePokemonRequest;
import com.pokemon.client.dto.request.PokemonRequest;
import com.pokemon.client.dto.response.PokemonResponse;
import com.pokemon.client.rest.PokemonApi;
import com.pokemon.domain.port.input.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PokemonRestController implements PokemonApi {

    private final GetAllPokemonUseCase getAllPokemon;
    private final GetPokemonUseCase getPokemon;
    private final CreatePokemonUseCase createPokemon;
    private final UpdatePokemonUseCase updatePokemon;
    private final DeletePokemonUseCase deletePokemon;
    private final GetPokemonByNameStartUseCase getPokemonByNameStartWith;
    private final GetTopHeaviestPokemonUseCase getTopHeaviestPokemon;
    private final GetTopExperiencePokemonUseCase getTopExperiencePokemon;

    private final PokemonMapper pokemonMapper;

    @Override
    public Page<PokemonResponse> getAllPokemon() throws Exception {
        Pageable pageable = PageRequest.of(0, 10);
        final var output = getAllPokemon.execute();
        return new PageImpl<>(
         pokemonMapper.toGetAllPokemonResponse(output.getPokemon()), pageable, output.getTotalElements());
    }

    @Override
    public PokemonResponse getPokemonById(final UUID pokemonId) throws Exception {
        final var output = getPokemon.execute(pokemonMapper.toGetPokemonInputValues(pokemonId));
        return pokemonMapper.toGetPokemonResponse(output.getPokemon().getId());
    }

    @Override
    public PokemonResponse createPokemon(final CreatePokemonRequest createPokemonRequest) throws Exception {
        final var input = pokemonMapper.toCreatePokemonInputValues(createPokemonRequest);
        final var output = createPokemon.execute(input);
        return pokemonMapper.toPokemonResponse(output.getPokemon());
    }

    @Override
    public PokemonResponse updatePokemon(final PokemonRequest pokemonRequest) throws Exception {
        final var output = updatePokemon.execute(pokemonMapper.toUpdatePokemonInputValues(pokemonRequest));
        return pokemonMapper.toPokemonResponse(output.getPokemon());
    }

    @Override
    public void deletePokemon(final UUID pokemonId) throws Exception {
        deletePokemon.execute(pokemonMapper.toDeletePokemonInputValues(pokemonId));
    }

    @Override
    public List<PokemonResponse> pokemonWithNamePrefix(final UUID pokemonId) throws Exception {
        final var output = getPokemonByNameStartWith.execute(pokemonMapper.toGetPokemonByNameStart(pokemonId));
        return pokemonMapper.toGetPokemonListResponse(output.getPokemon());
    }

    @Override
    public List<PokemonResponse> topHeaviest(final int limit) throws Exception {
        final var output = getTopHeaviestPokemon.execute(pokemonMapper.toGetTopHeaviestPokemon(limit));
        return pokemonMapper.toGetPokemonListResponse(output.getPokemon());
    }

    @Override
    public List<PokemonResponse> topExperience(final int limit) throws Exception {
        final var output = getTopExperiencePokemon.execute(pokemonMapper.toGetTopExperiencePokemon(limit));
        return pokemonMapper.toGetPokemonListResponse(output.getPokemon());
    }
}