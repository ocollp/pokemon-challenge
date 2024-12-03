package com.pokemon.domain.port.input.interactor;

import com.pokemon.domain.exception.NotFoundException;
import com.pokemon.domain.factory.PokemonFactory;
import com.pokemon.domain.port.input.GetPokemonUseCase;
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

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GetPokemonInteractorTest {

    @Mock
    private PokemonRepository pokemonRepository;

    private GetPokemonInteractor getPokemonInteractor;

    public static final GetPokemonInteractor.InputValues INPUT_POKEMON_ID = GetPokemonInteractor.InputValues.builder().id(PokemonFactory.ID_FIRE).build();

    @BeforeEach
    public void initMocks() throws Exception {
        Mockito.when(pokemonRepository.retrievePokemon(Mockito.any())).thenReturn(Optional.of(PokemonFactory.POKEMON_FIRE));
        getPokemonInteractor = new GetPokemonInteractor(pokemonRepository);
    }

    @Test
    public void executeGetPokemonOK() throws Exception {
        final GetPokemonUseCase.OutputValues output = getPokemonInteractor.execute(INPUT_POKEMON_ID);
        assertNotNull(output);
        assertNotNull(output.getPokemon());
        assertEquals(PokemonFactory.POKEMON_FIRE.getBaseExperience(), output.getPokemon().getBaseExperience());
        assertEquals(PokemonFactory.POKEMON_FIRE.getWeight(), output.getPokemon().getWeight());
        assertNotNull(output.getPokemon().getId());
    }

    @Test
    public void executeGetPokemonNotFoundKO() throws Exception {
        Mockito.when(pokemonRepository.retrievePokemon(PokemonFactory.ID_FIRE)).thenReturn(Optional.empty());
        Exception exception = assertThrows(NotFoundException.class, () -> {
            getPokemonInteractor.execute(GetPokemonUseCase.InputValues.builder().id(PokemonFactory.ID_FIRE).build());
        });
        assertNotNull(exception);
        assertNotNull(exception.getMessage());
    }
}