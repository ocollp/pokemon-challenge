package com.pokemon.domain.port.input.interactor;

import com.pokemon.domain.entity.Pokemon;
import com.pokemon.domain.port.input.GetAllPokemonUseCase;
import com.pokemon.domain.port.output.PokemonRepository;
import com.pokemon.domain.shared.annotation.Interactor;
import com.pokemon.domain.shared.dto.PageDTO;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Interactor
@RequiredArgsConstructor
public class GetAllPokemonInteractor implements GetAllPokemonUseCase {

    private final PokemonRepository pokemonRepository;

    private final Mapper mapper = Mappers.getMapper(Mapper.class);

    @Override
    public OutputValues execute() throws Exception {
        final PageDTO<List<Pokemon>> pokemonPage = pokemonRepository.retrieveAllPokemon();
        return mapper.toOutputValues(pokemonPage);
    }
}