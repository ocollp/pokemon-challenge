package com.pokemon.domain.port.input;

import com.pokemon.domain.entity.Pokemon;
import com.pokemon.domain.shared.UseCaseWithParameters;
import com.pokemon.domain.shared.dto.PageDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public interface GetPokemonByNameStartUseCase extends UseCaseWithParameters<GetPokemonByNameStartUseCase.InputValues, GetPokemonByNameStartUseCase.OutputValues> {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class InputValues implements UseCaseWithParameters.InputValues {
        private String nameStart;
    }

    @Data
    @Builder
    class OutputValues implements UseCaseWithParameters.OutputValues {
        private List<Pokemon> pokemon;
    }

    @org.mapstruct.Mapper
    interface Mapper {
        default GetPokemonByNameStartUseCase.OutputValues toOutputValues(final List<Pokemon> pokemonList) {
            return OutputValues.builder().pokemon(pokemonList).build();
        }
    }
}