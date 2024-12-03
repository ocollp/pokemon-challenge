package com.pokemon.domain.port.input.interactor;

import com.pokemon.domain.entity.Pokemon;
import com.pokemon.domain.exception.NotFoundException;
import com.pokemon.domain.port.input.DeletePokemonUseCase;
import com.pokemon.domain.port.output.PokemonRepository;
import com.pokemon.domain.shared.enums.ErrorEnum;
import com.pokemon.domain.shared.annotation.Interactor;
import lombok.RequiredArgsConstructor;

@Interactor
@RequiredArgsConstructor
public class DeletePokemonInteractor implements DeletePokemonUseCase {

    private final PokemonRepository pokemonRepository;

    @Override
    public void execute(final DeletePokemonUseCase.InputValues input) throws Exception {
        final Pokemon pokemon = pokemonRepository.retrievePokemon(input.getId()).orElseThrow(() -> new NotFoundException((ErrorEnum.POKEMON_NOT_FOUND).getCode(), String.format(ErrorEnum.POKEMON_NOT_FOUND.getMessage(), input.getId())));
        pokemonRepository.deletePokemon(pokemon.getId());
    }
}