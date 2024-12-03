package com.pokemon.service;

import com.pokemon.dto.PokemonDto;
import com.pokemon.exception.PokemonNotFoundException;
import com.pokemon.mapper.PokemonMapper;
import com.pokemon.model.Pokemon;
import com.pokemon.repository.PokemonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
/*
@ExtendWith(MockitoExtension.class)
public class PokemonServiceImplTest {

    @Mock
    private PokemonRepository pokemonRepository;

    @Mock
    private PokemonMapper pokemonMapper;

    @InjectMocks
    private PokemonServiceImpl pokemonService;

    private PokemonDto pokemonDto;
    private Pokemon pokemon;
    private UUID pokemonId;

    @BeforeEach
    void setUp() {
        pokemonId = UUID.randomUUID();
        pokemonDto = new PokemonDto("Pikachu", 6.0, 100);
        pokemon = new Pokemon(pokemonId, "Pikachu", 6.0, 100);
    }

    @Test
    void createPokemon_ShouldReturnSavedPokemonDto() {
        when(pokemonMapper.toEntity(pokemonDto)).thenReturn(pokemon);
        when(pokemonRepository.save(pokemon)).thenReturn(pokemon);
        when(pokemonMapper.toDto(pokemon)).thenReturn(pokemonDto);

        PokemonDto result = pokemonService.createPokemon(pokemonDto);

        assertEquals(pokemonDto, result);
        verify(pokemonMapper, times(1)).toEntity(pokemonDto);
        verify(pokemonRepository, times(1)).save(pokemon);
    }

    @Test
    void getAllPokemons_ShouldReturnListOfPokemonDtos() {
        List<Pokemon> pokemons = List.of(pokemon);
        when(pokemonRepository.findAll()).thenReturn(pokemons);
        when(pokemonMapper.toDto(pokemon)).thenReturn(pokemonDto);

        List<PokemonDto> result = pokemonService.getAllPokemons();

        assertEquals(1, result.size());
        assertEquals(pokemonDto, result.get(0));
        verify(pokemonRepository, times(1)).findAll();
    }

    @Test
    void getPokemonById_ShouldReturnPokemonDto() {
        when(pokemonRepository.findById(pokemonId)).thenReturn(Optional.of(pokemon));
        when(pokemonMapper.toDto(pokemon)).thenReturn(pokemonDto);

        Optional<PokemonDto> result = pokemonService.getPokemonById(pokemonId);

        assertTrue(result.isPresent());
        assertEquals(pokemonDto, result.get());
        verify(pokemonRepository, times(1)).findById(pokemonId);
    }

    @Test
    void getPokemonById_WhenPokemonNotFound_ShouldReturnEmpty() {
        when(pokemonRepository.findById(pokemonId)).thenReturn(Optional.empty());

        Optional<PokemonDto> result = pokemonService.getPokemonById(pokemonId);

        assertTrue(result.isEmpty());
        verify(pokemonRepository, times(1)).findById(pokemonId);
    }

    @Test
    void updatePokemon_ShouldReturnUpdatedPokemonDto() {
        PokemonDto updatedPokemonDto = new PokemonDto("Raichu", 6.0, 200);
        Pokemon updatedPokemon = new Pokemon(pokemonId, "Raichu", 6.0, 200);

        when(pokemonRepository.findById(pokemonId)).thenReturn(Optional.of(pokemon));
        when(pokemonRepository.save(any(Pokemon.class))).thenReturn(updatedPokemon);
        when(pokemonMapper.toDto(updatedPokemon)).thenReturn(updatedPokemonDto);

        Optional<PokemonDto> result = pokemonService.updatePokemon(pokemonId, updatedPokemonDto);

        assertTrue(result.isPresent());
        assertEquals(updatedPokemonDto, result.get());
        verify(pokemonRepository, times(1)).save(any(Pokemon.class));
    }

    @Test
    void deletePokemon_ShouldInvokeRepositoryDelete() {
        pokemonService.deletePokemon(pokemonId);
        verify(pokemonRepository, times(1)).deleteById(pokemonId);
    }

    @Test
    void findByNameStartsWith_ShouldReturnListOfPokemonDtos() {
        String prefix = "Pik";
        List<Pokemon> pokemons = List.of(pokemon);

        when(pokemonRepository.findByNameStartingWith(prefix)).thenReturn(pokemons);
        when(pokemonMapper.toDto(pokemon)).thenReturn(pokemonDto);

        List<PokemonDto> result = pokemonService.findByNameStartsWith(prefix);

        assertEquals(1, result.size());
        assertEquals(pokemonDto, result.get(0));
        verify(pokemonRepository, times(1)).findByNameStartingWith(prefix);
    }

    @Test
    void findByNameStartsWith_WhenNoPokemonsFound_ShouldThrowException() {
        String prefix = "Zzz";
        when(pokemonRepository.findByNameStartingWith(prefix)).thenReturn(List.of());

        assertThrows(PokemonNotFoundException.class, () -> pokemonService.findByNameStartsWith(prefix));
    }

    @Test
    void findTopHeaviest_ShouldReturnListOfPokemonDtos() {
        List<Pokemon> pokemons = List.of(pokemon);
        when(pokemonRepository.findTop3ByOrderByWeightDesc()).thenReturn(pokemons);
        when(pokemonMapper.toDto(pokemon)).thenReturn(pokemonDto);

        List<PokemonDto> result = pokemonService.findTopHeaviest(3);

        assertEquals(1, result.size());
        assertEquals(pokemonDto, result.get(0));
        verify(pokemonRepository, times(1)).findTop3ByOrderByWeightDesc();
    }

    @Test
    void findTopHeaviest_WhenNoPokemonsFound_ShouldThrowException() {
        when(pokemonRepository.findTop3ByOrderByWeightDesc()).thenReturn(List.of());

        assertThrows(PokemonNotFoundException.class, () -> pokemonService.findTopHeaviest(3));
    }

    @Test
    void findTopExperience_ShouldReturnListOfPokemonDtos() {
        List<Pokemon> pokemons = List.of(pokemon);
        when(pokemonRepository.findTop3ByOrderByBaseExperienceDesc()).thenReturn(pokemons);
        when(pokemonMapper.toDto(pokemon)).thenReturn(pokemonDto);

        List<PokemonDto> result = pokemonService.findTopExperience(3);

        assertEquals(1, result.size());
        assertEquals(pokemonDto, result.get(0));
        verify(pokemonRepository, times(1)).findTop3ByOrderByBaseExperienceDesc();
    }

    @Test
    void findTopExperience_WhenNoPokemonsFound_ShouldThrowException() {
        when(pokemonRepository.findTop3ByOrderByBaseExperienceDesc()).thenReturn(List.of());

        assertThrows(PokemonNotFoundException.class, () -> pokemonService.findTopExperience(3));
    }
}*/