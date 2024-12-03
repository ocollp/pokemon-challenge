package com.pokemon.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/*
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void accessPublicEndpoint_ReturnsOk() throws Exception {
        mockMvc.perform(get("/pokemons/heaviest")).andExpect(status().isOk());
    }

    @Test
    public void accessProtectedEndpoint_WithoutAuth_ReturnsUnauthorized() throws Exception {
        mockMvc.perform(get("/pokemons/top-experience")).andExpect(status().isUnauthorized());
    }
}*/