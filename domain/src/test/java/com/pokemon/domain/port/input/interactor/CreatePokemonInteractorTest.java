package com.pokemon.domain.port.input.interactor;

import com.pokemon.domain.factory.PokemonFactory;
import com.pokemon.domain.port.input.CreatePokemonUseCase;
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

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CreatePokemonInteractorTest {

    @Mock
    private PokemonRepository pokemonRepository;

    private CreatePokemonInteractor createPokemonInteractor;

    @BeforeEach
    public void initMocks() throws Exception {
        Mockito.when(pokemonRepository.createPokemon(Mockito.any())).thenReturn(PokemonFactory.POKEMON_FIRE);
        createPokemonInteractor = new CreatePokemonInteractor(pokemonRepository);
    }

    @Test
    public void executeCreatePokemonOK() throws Exception {
        final CreatePokemonUseCase.InputValues input = CreatePokemonUseCase.InputValues.builder().pokemon(PokemonFactory.POKEMON_FIRE).build();
        CreatePokemonUseCase.OutputValues output = createPokemonInteractor.execute(input);
        assertNotNull(output);
        assertNotNull(output.getPokemon());
        assertEquals(PokemonFactory.WEIGHT_FIRE, output.getPokemon().getWeight());
        assertEquals(PokemonFactory.BASE_EXPERIENCE_FIRE, output.getPokemon().getBaseExperience());
    }
}