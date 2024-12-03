package com.pokemon.domain.port.input.interactor;

import com.pokemon.domain.factory.PokemonFactory;
import com.pokemon.domain.port.input.GetAllPokemonUseCase;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GetAllPokemonInteractorTest {

    @Mock
    private PokemonRepository pokemonRepository;

    private GetAllPokemonInteractor getAllPokemonInteractor;

    @BeforeEach
    public void initMocks() throws Exception {
        Mockito.when(pokemonRepository.retrieveAllPokemon()).thenReturn(PokemonFactory.POKEMON_PAGE);
        getAllPokemonInteractor = new GetAllPokemonInteractor(pokemonRepository);
    }

    @Test
    public void executeGetAllPokemonOK() throws Exception {
        final GetAllPokemonUseCase.OutputValues output = getAllPokemonInteractor.execute();
        assertNotNull(output);
        assertNotNull(output.getPokemon());

        assertEquals(PokemonFactory.POKEMON_FIRE.getBaseExperience(), output.getPokemon().get(0).getBaseExperience());
        assertEquals(PokemonFactory.POKEMON_WATER.getWeight(), output.getPokemon().get(1).getWeight());
    }
}