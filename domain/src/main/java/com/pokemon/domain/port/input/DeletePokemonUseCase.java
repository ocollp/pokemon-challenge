package com.pokemon.domain.port.input;

import com.pokemon.domain.shared.UseCaseWithoutOutput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

public interface DeletePokemonUseCase extends UseCaseWithoutOutput<DeletePokemonUseCase.InputValues> {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class InputValues implements UseCaseWithoutOutput.InputValues {
        private UUID id;
    }
}
