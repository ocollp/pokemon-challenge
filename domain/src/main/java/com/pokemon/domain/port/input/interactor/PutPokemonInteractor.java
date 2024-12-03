package com.pokemon.domain.port.input.interactor;

import com.pokemon.domain.port.input.PutPokemonUseCase;
import com.pokemon.domain.port.output.PokemonRepository;
import com.pokemon.domain.shared.annotation.Interactor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

@Interactor
@RequiredArgsConstructor
public class PutPokemonInteractor implements PutPokemonUseCase {

    private final PokemonRepository pokemonRepository;
    private final Mapper mapper = Mappers.getMapper(Mapper.class);

    @Override
    public OutputValues execute(final InputValues input) throws Exception {
        return mapper.toOutputValues(pokemonRepository.updatePokemon(input.getPokemon()));
    }
}