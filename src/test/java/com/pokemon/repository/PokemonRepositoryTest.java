/*package com.pokemon.repository;

import com.pokemon.model.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PokemonRepositoryTest {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    void testFindByNameStartingWith() {
        // Act
        List<Pokemon> result = pokemonRepository.findByNameStartingWith("P");

        // Assert
        assertThat(result).hasSize(2); // Pikachu, Psyduck
        assertThat(result).extracting(Pokemon::getName)
                .containsExactlyInAnyOrder("Pikachu", "Psyduck");
    }

    @Test
    void testFindTop3ByOrderByWeightDesc() {
        // Act
        List<Pokemon> result = pokemonRepository.findTop3ByOrderByWeightDesc();

        // Assert
        assertThat(result).hasSize(3);
        assertThat(result).extracting(Pokemon::getName)
                .containsExactly("Snorlax", "Onix", "Gengar"); // Ordenados por peso
    }

    @Test
    void testFindTop3ByOrderByBaseExperienceDesc() {
        // Act
        List<Pokemon> result = pokemonRepository.findTop3ByOrderByBaseExperienceDesc();

        // Assert
        assertThat(result).hasSize(3);
        assertThat(result).extracting(Pokemon::getName)
                .containsExactly("Gengar", "Snorlax", "Charmander"); // Ordenados por experiencia base
    }
}*/