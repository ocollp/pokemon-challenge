package com.pokemon.domain.port.input.interactor;

import com.pokemon.domain.entity.Pokemon;
import com.pokemon.domain.port.input.GetTopExperiencePokemonUseCase;
import com.pokemon.domain.port.input.GetTopHeaviestPokemonUseCase;
import com.pokemon.domain.port.output.PokemonRepository;
import com.pokemon.domain.shared.annotation.Interactor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Interactor
@RequiredArgsConstructor
public class GetTopExperiencePokemonInteractor implements GetTopExperiencePokemonUseCase {

    private final PokemonRepository pokemonRepository;

    private final Mapper mapper = Mappers.getMapper(Mapper.class);

    @Override
    public OutputValues execute(final InputValues input) throws Exception {
        final List<Pokemon> pokemonList = pokemonRepository.retrieveTopExperiencePokemon(input.getLimit());
        return mapper.toOutputValues(pokemonList);
    }
}