package com.pokemon.controller;

import com.pokemon.dto.PokemonDto;
import com.pokemon.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
/*
@WebMvcTest(PokemonController.class)
public class PokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @Test
    void getPokemonById_Exists_ReturnsPokemon() throws Exception {
        UUID pokemonId = UUID.randomUUID();
        PokemonDto pokemonDto = new PokemonDto(pokemonId, "Pikachu", 60, 200);

        Mockito.when(pokemonService.getPokemonById(pokemonId)).thenReturn(Optional.of(pokemonDto));

        mockMvc.perform(get("/pokemons/{id}", pokemonId).with(user("testUser").password("testPass").roles("USER")).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(pokemonId.toString())).andExpect(jsonPath("$.name").value("Pikachu"));
    }

    @Test
    void getPokemonById_NotExists_ReturnsNotFound() throws Exception {
        UUID pokemonId = UUID.randomUUID();

        Mockito.when(pokemonService.getPokemonById(pokemonId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/pokemons/{id}", pokemonId).with(user("testUser").password("testPass").roles("USER")).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());

    }
}*/