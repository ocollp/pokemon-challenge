package com.pokemon.domain.port.input.interactor;

import com.pokemon.domain.exception.NotFoundException;
import com.pokemon.domain.factory.PokemonFactory;
import com.pokemon.domain.port.input.DeletePokemonUseCase;
import com.pokemon.domain.port.output.PokemonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DeletePokemonInteractorTest {

    @Mock
    private PokemonRepository pokemonRepository;

    private DeletePokemonInteractor deletePokemonInteractor;

    @BeforeEach
    public void initMocks() throws Exception {
        Mockito.doNothing().when(pokemonRepository).deletePokemon(PokemonFactory.ID_FIRE);
        deletePokemonInteractor = new DeletePokemonInteractor(pokemonRepository);
    }

    @Test
    void executeDeletePokemonSuccessfully() throws Exception {
        final UUID pokemonId = PokemonFactory.ID_FIRE;
        Mockito.when(pokemonRepository.retrievePokemon(pokemonId)).thenReturn(Optional.of(PokemonFactory.POKEMON_FIRE));
        deletePokemonInteractor.execute(DeletePokemonUseCase.InputValues.builder().id(pokemonId).build());
        Mockito.verify(pokemonRepository).deletePokemon(pokemonId);
    }

    @Test
    void executeDeletePokemonThrowsExceptionWhenPokemonNotFound() {
        Mockito.when(pokemonRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        NotFoundException exception = assertThrows(NotFoundException.class, () -> deletePokemonInteractor.execute(DeletePokemonUseCase.InputValues.builder().id(UUID.randomUUID()).build())  // ID del Pokémon que no existe
        );
        assertEquals(PokemonFactory.POKEMON_NOT_FOUND_CODE, exception.getMessage());
    }
}