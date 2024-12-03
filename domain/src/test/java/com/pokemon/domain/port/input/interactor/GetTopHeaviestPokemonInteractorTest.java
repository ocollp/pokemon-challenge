package com.pokemon.domain.port.input.interactor;

import com.pokemon.domain.factory.PokemonFactory;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GetTopHeaviestPokemonInteractorTest {

    @Mock
    private PokemonRepository pokemonRepository;

    private GetTopHeaviestPokemonInteractor getTopHeaviestPokemonInteractor;

    @BeforeEach
    public void initMocks() throws Exception {
        Mockito.when(pokemonRepository.retrieveTopHeaviestPokemon(Mockito.anyInt())).thenReturn(List.of(PokemonFactory.POKEMON_FIRE));
        getTopHeaviestPokemonInteractor = new GetTopHeaviestPokemonInteractor(pokemonRepository);
    }

    @Test
    public void executeRetrievePokemonByNameStartOK() throws Exception {
        final GetTopHeaviestPokemonInteractor.InputValues input = GetTopHeaviestPokemonInteractor.InputValues.builder().limit(3).build();
        GetTopHeaviestPokemonInteractor.OutputValues output = getTopHeaviestPokemonInteractor.execute(input);
        assertNotNull(output);
        assertNotNull(output.getPokemon());
        assertEquals(PokemonFactory.WEIGHT_FIRE, output.getPokemon().get(0).getWeight());
    }
}