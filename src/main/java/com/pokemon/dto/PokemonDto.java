package com.pokemon.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDto {
    private UUID id;
    private String name;
    private double weight;
    private int baseExperience;
}