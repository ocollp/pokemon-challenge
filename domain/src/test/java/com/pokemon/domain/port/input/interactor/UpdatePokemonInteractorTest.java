package com.pokemon.domain.port.input.interactor;

import com.pokemon.domain.factory.PokemonFactory;
import com.pokemon.domain.port.input.UpdatePokemonUseCase;
import com.pokemon.domain.port.output.PokemonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UpdatePokemonInteractorTest {

    @Mock
    private PokemonRepository pokemonRepository;

    private UpdatePokemonInteractor updatePokemonInteractor;

    @BeforeEach
    public void initMocks() throws Exception {
        Mockito.when(pokemonRepository.updatePokemon(Mockito.any())).thenReturn(PokemonFactory.POKEMON_FIRE_UPDATED);
        updatePokemonInteractor = new UpdatePokemonInteractor(pokemonRepository);
    }

    @Test
    public void executeUpdatePokemonOK() throws Exception {
        UpdatePokemonUseCase.OutputValues output = updatePokemonInteractor.execute(UpdatePokemonUseCase.InputValues.builder().pokemon(PokemonFactory.POKEMON_FIRE_UPDATED).build());
        Assertions.assertEquals(PokemonFactory.POKEMON_FIRE_NAME_UPDATED, output.getPokemon().getName());
    }
}