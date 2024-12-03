package com.pokemon.domain.port.input;

import com.pokemon.domain.entity.Pokemon;
import com.pokemon.domain.shared.UseCaseWithParameters;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface CreatePokemonUseCase extends UseCaseWithParameters<CreatePokemonUseCase.InputValues, CreatePokemonUseCase.OutputValues> {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class InputValues implements UseCaseWithParameters.InputValues {
        private Pokemon pokemon;
    }

    @Data
    @Builder
    class OutputValues implements UseCaseWithParameters.OutputValues {
        private Pokemon pokemon;
    }

    @org.mapstruct.Mapper
    interface Mapper {
        default OutputValues toOutputValues(final Pokemon pokemon) {
            return OutputValues.builder().pokemon(pokemon).build();
        }
    }
}