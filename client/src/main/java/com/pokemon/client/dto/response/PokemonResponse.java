package com.pokemon.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonResponse implements Serializable {
    private UUID id;
    private String name;
    private double weight;
    private int baseExperience;
}