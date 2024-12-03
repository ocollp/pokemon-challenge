package com.pokemon.domain.port.input.interactor;

import com.pokemon.domain.entity.Pokemon;
import com.pokemon.domain.exception.NotFoundException;
import com.pokemon.domain.port.input.GetPokemonUseCase;
import com.pokemon.domain.port.output.PokemonRepository;
import com.pokemon.domain.shared.annotation.Interactor;
import com.pokemon.domain.shared.enums.ErrorEnum;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

@Interactor
@RequiredArgsConstructor
public class GetPokemonInteractor implements GetPokemonUseCase {

    private final PokemonRepository pokemonRepository;

    private final Mapper mapper = Mappers.getMapper(Mapper.class);

    @Override
    public OutputValues execute(final InputValues input) throws Exception {
        final Pokemon pokemon = pokemonRepository.retrievePokemon(input.getId()).orElseThrow(() -> new NotFoundException((ErrorEnum.POKEMON_NOT_FOUND).getCode(), String.format(ErrorEnum.POKEMON_NOT_FOUND.getMessage(), input.getId())));
        return mapper.toOutputValues(pokemon);
    }
}