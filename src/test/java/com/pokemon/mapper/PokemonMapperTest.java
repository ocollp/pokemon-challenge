package com.pokemon.mapper;

import com.pokemon.dto.PokemonDto;
import com.pokemon.model.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*@SpringBootTest
public class PokemonMapperTest {

    @Autowired
    private PokemonMapper pokemonMapper;

    @Test
    void testToDto() {
        Pokemon pokemon = new Pokemon();
        pokemon.setName("Pikachu");
        pokemon.setWeight(6.0);
        pokemon.setBaseExperience(112);

        PokemonDto pokemonDto = pokemonMapper.toDto(pokemon);

        assertEquals("Pikachu", pokemonDto.getName());
        assertEquals(6.0, pokemonDto.getWeight());
        assertEquals(112, pokemonDto.getBaseExperience());
    }

    @Test
    void testToEntity() {
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setName("Bulbasaur");
        pokemonDto.setWeight(6.9);
        pokemonDto.setBaseExperience(64);

        Pokemon pokemon = pokemonMapper.toEntity(pokemonDto);

        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(6.9, pokemon.getWeight());
        assertEquals(64, pokemon.getBaseExperience());
    }
}*/