package com.pokemon.domain.port.input;

import com.pokemon.domain.entity.Pokemon;
import com.pokemon.domain.shared.UseCaseWithParameters;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public interface GetTopExperiencePokemonUseCase extends UseCaseWithParameters<GetTopExperiencePokemonUseCase.InputValues, GetTopExperiencePokemonUseCase.OutputValues> {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class InputValues implements UseCaseWithParameters.InputValues {
        private int limit;
    }

    @Data
    @Builder
    class OutputValues implements UseCaseWithParameters.OutputValues {
        private List<Pokemon> pokemon;
    }

    @org.mapstruct.Mapper
    interface Mapper {
        default GetTopExperiencePokemonUseCase.OutputValues toOutputValues(final List<Pokemon> pokemonList) {
            return OutputValues.builder().pokemon(pokemonList).build();
        }
    }
}