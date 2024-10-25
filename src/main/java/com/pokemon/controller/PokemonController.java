package com.pokemon.controller;

import com.pokemon.dto.PokemonDto;
import com.pokemon.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<List<PokemonDto>> getAllPokemons() {
        try {
            List<PokemonDto> pokemons = pokemonService.getAllPokemons();
            return ResponseEntity.ok(pokemons);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @PostMapping
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemon) {
        PokemonDto createdPokemon = pokemonService.createPokemon(pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPokemon);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDto> getPokemonById(@PathVariable UUID id) {
        Optional<PokemonDto> pokemon = pokemonService.getPokemonById(id);
        return pokemon.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonDto> updatePokemon(@PathVariable UUID id, @RequestBody PokemonDto updatedPokemon) {
        Optional<PokemonDto> updated = pokemonService.updatePokemon(id, updatedPokemon);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable UUID id) {
        pokemonService.deletePokemon(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<PokemonDto>> searchPokemonByName(@RequestParam(value = "nameStartsWith") String nameStartsWith) {
        if (nameStartsWith != null && nameStartsWith.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }

        List<PokemonDto> pokemons = pokemonService.findByNameStartsWith(nameStartsWith);

        if (pokemons.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
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