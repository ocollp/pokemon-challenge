package com.pokemon.domain.entity;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Pokemon implements Serializable {

    private UUID id;
    private String name;
    private double weight;
    private int baseExperience;
}