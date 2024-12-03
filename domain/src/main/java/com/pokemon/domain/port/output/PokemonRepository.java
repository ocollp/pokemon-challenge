package com.pokemon.domain.port.output;

import com.pokemon.domain.shared.annotation.DomainRepository;
import com.pokemon.domain.entity.Pokemon;
import com.pokemon.domain.shared.dto.PageDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DomainRepository
public interface PokemonRepository extends JpaRepository<Pokemon, UUID> {

    PageDTO<List<Pokemon>> retrieveAllPokemon();

    Optional<Pokemon> retrievePokemon(UUID id);

    Pokemon createPokemon(Pokemon pokemon);

    Pokemon updatePokemon(Pokemon pokemon);

    void deletePokemon(UUID id);

    List<Pokemon> retrievePokemonByNameStartWith(String nameStart);

    List<Pokemon> retrieveTopHeaviestPokemon(int limit);

    List<Pokemon> retrieveTopExperiencePokemon(int limit);
}