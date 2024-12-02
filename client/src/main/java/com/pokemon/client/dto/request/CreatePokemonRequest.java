package com.pokemon.client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePokemonRequest {
    @NotBlank
    private String name;
    @NotBlank
    private double weight;
    @NotBlank
    private int baseExperience;
}