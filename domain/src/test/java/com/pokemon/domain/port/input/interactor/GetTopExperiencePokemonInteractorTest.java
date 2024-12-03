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
public class GetTopExperiencePokemonInteractorTest {

    @Mock
    private PokemonRepository pokemonRepository;

    private GetTopExperiencePokemonInteractor getTopExperiencePokemonInteractor;

    @BeforeEach
    public void initMocks() throws Exception {
        Mockito.when(pokemonRepository.retrieveTopExperiencePokemon(Mockito.anyInt())).thenReturn(List.of(PokemonFactory.POKEMON_FIRE));
        getTopExperiencePokemonInteractor = new GetTopExperiencePokemonInteractor(pokemonRepository);
    }

    @Test
    public void executeRetrievePokemonByNameStartOK() throws Exception {
        final GetTopExperiencePokemonInteractor.InputValues input = GetTopExperiencePokemonInteractor.InputValues.builder().limit(3).build();
        GetTopExperiencePokemonInteractor.OutputValues output = getTopExperiencePokemonInteractor.execute(input);
        assertNotNull(output);
        assertNotNull(output.getPokemon());
        assertEquals(PokemonFactory.BASE_EXPERIENCE_FIRE, output.getPokemon().get(0).getBaseExperience());
    }
}