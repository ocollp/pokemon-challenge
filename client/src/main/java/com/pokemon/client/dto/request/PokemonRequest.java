package com.pokemon.client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonRequest {
    @NotNull
    private UUID id;
    private String name;
    private double weight;
    private int baseExperience;
}