package com.pokemon.repository;

import com.pokemon.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonJpaRepository extends JpaRepository<Pokemon, Long>, PokemonRepository {}