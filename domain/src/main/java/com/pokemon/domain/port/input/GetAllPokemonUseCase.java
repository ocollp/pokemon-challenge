package com.pokemon.domain.port.input;

import com.pokemon.domain.entity.Pokemon;
import com.pokemon.domain.shared.UseCaseWithParameters;
import com.pokemon.domain.shared.UseCaseWithoutInput;
import com.pokemon.domain.shared.dto.PageDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public interface GetAllPokemonUseCase extends UseCaseWithoutInput<GetAllPokemonUseCase.OutputValues> {

    @Data
    @Builder
    class OutputValues implements UseCaseWithParameters.OutputValues, UseCaseWithoutInput.OutputValues {
        private List<Pokemon> pokemon;
        private Long totalElements;
    }

    @org.mapstruct.Mapper
    interface Mapper {
        default OutputValues toOutputValues(final PageDTO<List<Pokemon>> pokemonPage) {
            return OutputValues.builder().pokemon(pokemonPage.getContent()).totalElements(pokemonPage.getTotalElements()).build();
        }
    }
}