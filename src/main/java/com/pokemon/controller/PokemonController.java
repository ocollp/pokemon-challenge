package com.pokemon.controller;

import com.pokemon.dto.PokemonDto;
import com.pokemon.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<List<PokemonDto>> searchPokemonByName(
            @RequestParam(value = "nameStartsWith", required = false) String nameStartsWith) {
        if (nameStartsWith != null && nameStartsWith.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }

        List<PokemonDto> pokemons = pokemonService.findByNameStartsWith(nameStartsWith);

        if (pokemons.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.emptyList());
        }
        return ResponseEntity.ok(pokemons);
    }

    @GetMapping("/heaviest")
    public ResponseEntity<List<PokemonDto>> getHeaviestPokemons() {
        List<PokemonDto> heaviestPokemons = pokemonService.findTopHeaviest(3);
        return ResponseEntity.ok(heaviestPokemons);
    }

    @GetMapping("/top-experience")
    public ResponseEntity<List<PokemonDto>> getTopExperiencePokemons() {
        List<PokemonDto> topExperiencePokemons = pokemonService.findTopExperience(3);
        return ResponseEntity.ok(topExperiencePokemons);
    }
}