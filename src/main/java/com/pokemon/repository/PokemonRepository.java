package com.pokemon.repository;

import com.pokemon.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, UUID> {

    List<Pokemon> findByNameStartingWith(String nameStartsWith);

    List<Pokemon> findTop3ByOrderByWeightDesc();

    List<Pokemon> findTop3ByOrderByBaseExperienceDesc();
}

